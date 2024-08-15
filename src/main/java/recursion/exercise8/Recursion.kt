package recursion.exercise8

import recursion.exercise5.foldLeft

/**
 * Определите функцию reverse, использующую только версию оператора +,
 * добавляющую элемент в конец списка.
 */
fun main() {
    println(reverse(listOf(2, 4, 8, 16)))
}

//Решение
fun <T> prepend(list: List<T>, elem: T): List<T> =
    foldLeft(list, listOf(elem)) { lst, elm -> lst + elm }

fun <T> reverse(list: List<T>) = foldLeft(list, listOf(), ::prepend)