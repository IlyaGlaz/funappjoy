package recursion.exercise12

/**
 * Напишите рекурсивную версию range, использовав функции из предыдущих разделов.
 */
fun main() {
    println(range(0, 101))
}

//Решение
fun <T> prepend(list: List<T>, elem: T): List<T> = listOf(elem) + list

fun range(start: Int, end: Int): List<Int> =
    if (end <= start)
        listOf()
    else
        prepend(range(start + 1, end), start)

