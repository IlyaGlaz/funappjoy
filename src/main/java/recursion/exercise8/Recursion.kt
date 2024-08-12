package recursion.exercise8

import recursion.exercise5.foldLeft

/**
 * Определите функцию reverse, использующую только версию оператора +,
 * добавляющую элемент в конец списка.
 */
fun main() {
    println(reverse(listOf(1, 2, 5, 10, 50, 150, 300, 600)))
}

//Решение
fun <T> prepend(list: List<T>, elem: T): List<T> = listOf(elem) + list

fun <T> reverse(list: List<T>) = foldLeft(list, listOf(), ::prepend)