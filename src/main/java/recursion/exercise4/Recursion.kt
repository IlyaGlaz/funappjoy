package recursion.exercise4

/**
 * Напишите версию функции makeString, использующую хвостовую рекурсию.
 * (Попробуйте не заглядывать в реализацию функции sum.)
 *
 * fun <T> makeString(list: List<T>, delim: String): String =
 *  when {
 *  list.isEmpty() -> ""
 *
 *  list.tail().isEmpty() -> "${list.head()}${makeString(list.tail(), delim)}"
 *
 *  else -> "${list.head()}$delim${makeString(list.tail(), delim)}"
 *  }
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
fun <T> makeString(list: List<T>, delim: String): String {
    tailrec fun makeString_(list: List<T>, acc: String): String =
        when {
            list.isEmpty() -> acc
            acc.isEmpty() -> makeString_(list.tail(), "${list.head()}")
            else -> makeString_(list.tail(), "$acc$delim${list.head()}")
        }
    return makeString_(list, "")
}
