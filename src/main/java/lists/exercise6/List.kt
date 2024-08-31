package lists.exercise6

import lists.exercise6.List.Cons
import lists.exercise6.List.Nil

/**
 * Напишите функцию, вычисляющую сумму элементов постоянного списка целых чисел, использовав рекурсивный подход.
 */
fun main() {
    println(sum(List(2, 4, 6, 8)))
    println(List(1, 2).concat(List(3, 4)))
}

//Решение
sealed class List<out A> {
    abstract fun isEmpty(): Boolean

    abstract fun init(): List<A>

    fun cons(a: @UnsafeVariance A): List<A> = Cons(a, this)

    fun setHead(a: @UnsafeVariance A): List<A> =
        when (this) {
            Nil -> throw IllegalStateException("setHead called on an empty list")
            is Cons -> Cons(a, this.tail)
        }

    fun drop(n: Int): List<A> = drop(this, n)

    fun dropWhile(p: (A) -> Boolean): List<A> = dropWhile(this, p)

    fun concat(list: List<@UnsafeVariance A>): List<A> = concat(this, list)

    fun reverse(): List<A> = reverse(invoke(), this)

    object Nil : List<Nothing>() {
        override fun init(): List<Nothing> = throw IllegalArgumentException()

        override fun isEmpty() = true

        override fun toString(): String = "[NIL]"
    }

    class Cons<out A>(val head: A, val tail: List<A>) : List<A>() {
        override fun init(): List<A> = reverse().drop(1).reverse()

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

        private tailrec fun <A> dropWhile(list: List<A>, p: (A) -> Boolean): List<A> {
            return when (list) {
                Nil -> list
                is Cons -> if (p(list.head)) dropWhile(list.tail, p) else list
            }
        }

        private fun <A> concat(list1: List<A>, list2: List<A>): List<A> = when (list1) {
            Nil -> list2
            is Cons -> concat(list1.tail, list2).cons(list1.head)
        }

        private tailrec fun <A> reverse(acc: List<A>, list: List<A>): List<A> =
            when (list) {
                Nil -> acc
                is Cons -> reverse(acc.cons(list.head), list.tail)
            }

        operator fun <A> invoke(vararg az: A): List<A> =
            az.foldRight(Nil as List<A>) { a: A, list: List<A> -> Cons(a, list) }
    }
}

fun sum(list: List<Int>): Int = when (list) {
    Nil -> 0
    is Cons -> sum(list.tail) + list.head
}
