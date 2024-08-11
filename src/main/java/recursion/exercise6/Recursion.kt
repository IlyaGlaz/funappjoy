package recursion.exercise6

/**
 * Рекурсия вместо сорекурсии
 *
 * fun string(list: List<Char>): String =
 *  if (list.isEmpty())
 *   ""
 *  else
 *   prepend(list.head(), string(list.tail()))
 *
 * Напишите эту абстрактную функцию и назовите ее foldRight. Затем перепишите функцию string, используя foldRight.
 */
fun main() {
    println(string(listOf('H', 'o', 'l', 'a')))
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

/**
 * Реализация рекурсии
 */
fun prepend(ch: Char, s: String): String = "$ch$s"

fun toString(list: List<Char>): String =
    if (list.isEmpty())
        ""
    else
        prepend(list[0], toString(list.subList(1, list.size)))

//Решение
fun <T, U> foldRight(list: List<T>, init: U, block: (T, U) -> U): U =
    if (list.isEmpty())
        init
    else
        block(list.head(), foldRight(list.tail(), init, block))

fun string(list: List<Char>) =
    foldRight(list, "") { elem, acc -> prepend(elem, acc) }