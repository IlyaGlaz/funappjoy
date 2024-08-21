package recursion.exercise17

import recursion.exercise6.head
import recursion.exercise6.tail

/**
 * Оределите функцию map, которая применяет функцию (T) -> U к каждому элементу в List<T> и производит List<U>.
 */
fun main() {
    println(map(listOf("Hi", "My", "Name", "Is")) { it.length })
}

//Решение
fun <T, U> map(list: List<T>, f: (T) -> U): List<U> {
    tailrec fun map(acc: List<U>, list: List<T>): List<U> =
        if (list.isEmpty())
            acc
        else
            map(acc + f(list.head()), list.tail())
    return map(listOf(), list)
}

