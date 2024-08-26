package lists.exercise5

/**
 * Напишите функцию удаления последнего элемента из списка. Функция
 * должна возвращать новый список. Реализуйте ее как функцию экземпляра со следующей сигнатурой:
 * fun init(): List<A>
 */
fun main() {
    println(List(2, 4, 6, 8).init())
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

    fun dropWhile(p: (A) -> Boolean): List<A> = dropWhile(this, p)

    fun concat(list: List<A>): List<A> = concat(this, list)

    fun init(): List<A> = init(this)

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
        private fun <A> init(list1: List<A>): List<A> = when (list1) {
            Nil -> list1
            is Cons -> if (list1.tail.isEmpty()) list1 else init(list1.tail)
        }

        private fun <A> concat(list1: List<A>, list2: List<A>): List<A> = when (list1) {
            Nil -> list2
            is Cons -> concat(list1.tail, list2).cons(list1.head)
        }

        private tailrec fun <A> dropWhile(list: List<A>, p: (A) -> Boolean): List<A> {
            return when (list) {
                Nil -> list
                is Cons -> if (p(list.head)) dropWhile(list.tail, p) else list
            }
        }

        private tailrec fun <A> drop(list: List<A>, n: Int): List<A> = when (list) {
            Nil -> list
            is Cons -> if (n <= 0) list else drop(list.tail, n - 1)
        }

        operator fun <A> invoke(vararg az: A): List<A> =
            az.foldRight(Nil as List<A>) { a: A, list: List<A> -> Cons(a, list) }
    }
}
