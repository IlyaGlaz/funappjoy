package lists.exercise12

/**
 * Перепишите foldRight, использовав в новой версии foldLeft.
 */
fun main() {

}

//Решение
sealed class List<out A> {
    abstract fun isEmpty(): Boolean

    fun cons(a: @UnsafeVariance A): List<A> = Cons(a, this)

    fun setHead(a: @UnsafeVariance A): List<A> =
        when (this) {
            Nil -> throw IllegalStateException("setHead called on an empty list")
            is Cons -> Cons(a, this.tail)
        }

    fun reverse(): List<A> = reverse(invoke(), this)

    fun <B> foldLeft(identity: B, f: (B) -> (A) -> B): B =
        foldLeft(identity, this, f)

    fun <B> foldRight(identity: B, f: (A) -> (B) -> B): B =
        foldRight(this, identity, f)

    /**
     * Решение
     */
    fun <B> foldRightViaFoldLeft(identity: B, f: (A) -> (B) -> B): B =
        this.reverse().foldLeft(identity) { x -> { y -> f(y)(x) } }

    object Nil : List<Nothing>() {
        override fun isEmpty() = true

        override fun toString(): String = "[NIL]"
    }

    class Cons<out A>(val head: A, val tail: List<A>) : List<A>() {
        override fun isEmpty() = false

        override fun toString(): String = "[${toString("", this)}NIL]"

        private tailrec fun toString(acc: String, list: List<A>): String = when (list) {
            Nil -> acc
            is Cons -> toString("$acc${list.head}, ", list.tail)
        }
    }

    companion object {
        private tailrec fun <A> reverse(acc: List<A>, list: List<A>): List<A> =
            when (list) {
                Nil -> acc
                is Cons -> reverse(acc.cons(list.head), list.tail)
            }

        fun <A, B> foldRight(list: List<A>, identity: B, f: (A) -> (B) -> B): B =
            when (list) {
                Nil -> identity
                is Cons -> f(list.head)(foldRight(list.tail, identity, f))
            }

        private tailrec fun <A, B> foldLeft(acc: B, list: List<A>, f: (B) -> (A) -> B): B {
            return when (list) {
                Nil -> acc
                is Cons -> foldLeft(f(acc)(list.head), list.tail, f)
            }
        }

        operator fun <A> invoke(vararg az: A): List<A> =
            az.foldRight(Nil as List<A>) { a: A, list: List<A> -> Cons(a, list) }
    }
}
