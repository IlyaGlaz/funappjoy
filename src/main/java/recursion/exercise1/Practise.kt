package recursion.exercise1

/**
 * Реализация сорекурсии
 */
fun append(s: String, ch: Char) = "$s$ch"

fun toString(list: List<Char>, str: String): String =
    if (list.isEmpty())
        str
    else
        toString(list.subList(1, list.size), append(str, list[0]))

/**
 * Реализация рекурсии
 */
fun prepend(ch: Char, s: String): String = "$ch$s"

fun toString(list: List<Char>): String =
    if (list.isEmpty())
        ""
    else
        prepend(list[0], toString(list.subList(1, list.size)))

/**
 *
 */
fun sum(n: Int): Int {
    tailrec fun sum(sum: Int, idx: Int): Int =
        if (idx > n)
            sum
        else sum(sum + idx, idx + 1)
    return sum(0, 0)
}

/**
 *
 */
fun added(a: Int, b: Int): Int =
    if (a == 0)
        b
    else
        added(a - 1, b + 1)
