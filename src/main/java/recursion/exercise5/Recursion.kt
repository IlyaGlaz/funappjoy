package recursion.exercise5

import recursion.exercise4.head
import recursion.exercise4.makeString
import recursion.exercise4.tail

/**
 * Напишите обобщенную версию функции с хвостовой рекурсией, которую можно использовать в sum, string и makeString.
 * Дайте этой функции имя foldLeft, затем перепишите sum, string и makeString, задействовав эту
 * новую функцию.
 */
fun main() {
    println(makeString(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), "-"))
}

fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.drop(1)

fun sum(list: List<Int>): Int =
    if (list.isEmpty())
        0
    else
        list.head() + sum(list.tail())

//Решение
