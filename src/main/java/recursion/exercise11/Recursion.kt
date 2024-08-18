package recursion.exercise11

import recursion.exercise10.unfold

/**
 * Реализуйте функцию range, используя unfold.
 */
fun main() {
    println(range(0, 101))
}

//Решение
fun range(start: Int, end: Int): List<Int> = unfold(start, { it + 1 }, { it < end })

