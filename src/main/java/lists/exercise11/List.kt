package lists.exercise11

import lists.exercise11.List.*

/**
 * Напишите функцию переворачивания списка, используя foldLeft..
 */
fun main() {
    println(reverse(List(6, 4, 2, 1)))
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

    fun <B> foldLeft(identity: B, f: (B) -> (A) -> B): B =
        foldLeft(identity, this, f)

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

/**
 * Решение
 */
fun <A> reverse(list: List<A>): List<A> = list.foldLeft(Nil as List<A>) { acc -> { acc.cons(it) } }
