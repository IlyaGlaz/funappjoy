package recursion.exercise7

import recursion.exercise5.foldLeft

/**
 * fun <T> reverse(list: List<T>): List<T> {
 *  val result: MutableList<T> = mutableListOf()
 *  (list.size downTo 1).forEach {
 *    result.add(list[it - 1])
 *  }
 *    return result
 * }
 *
 * Определите функцию reverse, используя fold.
 */
fun main() {
    println(reverse(listOf(1, 2, 5, 10, 50, 150, 300, 600)))
}

//Решение
fun <T> prepend(list: List<T>, elem: T): List<T> = listOf(elem) + list

fun <T> reverse(list: List<T>) = foldLeft(list, listOf(), ::prepend)