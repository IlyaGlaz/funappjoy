package lists.exercise3

/**
 * Напишите обобщенную функцию drop, которая удаляет первые n элементов из списка. Эта
 * функция должна не удалять элементы из имеющегося списка, а возвращать
 * новый список, соответствующий предполагаемому результату.
 */
fun main() {
    println(List(2, 4, 5).drop(1))
}

//Решение
sealed class List<A> {
    abstract fun isEmpty(): Boolean

    fun cons(a: A): List<A> = Cons(a, this)

    fun setHead(a: A): List<A> =
        when (this) {
            Nil -> throw IllegalStateException("setHead called on an empty list")
            is Cons -> Cons(a, this.tail)
        }

    fun drop(n: Int): List<A> = drop(this, n)

    private object Nil : List<Nothing>() {
        override fun isEmpty() = true

        override fun toString(): String = "[NIL]"
    }

    private class Cons<A>(val head: A, val tail: List<A>) : List<A>() {
        override fun isEmpty() = false

        override fun toString(): String = "[${toString("", this)}NIL]"

        private tailrec fun toString(acc: String, list: List<A>): String = when (list) {
            Nil -> acc
            is Cons -> toString("$acc${list.head}, ", list.tail)
        }
    }

    companion object {
        private tailrec fun <A> drop(list: List<A>, n: Int): List<A> = when (list) {
            Nil -> list
            is Cons -> if (n <= 0) list else drop(list.tail, n - 1)
        }

        operator fun <A> invoke(vararg az: A): List<A> =
            az.foldRight(Nil as List<A>) { a: A, list: List<A> -> Cons(a, list) }
    }
}
