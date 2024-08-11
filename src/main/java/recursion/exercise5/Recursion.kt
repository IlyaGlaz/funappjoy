package recursion.exercise5

/**
 * Напишите обобщенную версию функции с хвостовой рекурсией, которую можно использовать в sum, string и makeString.
 * Дайте этой функции имя foldLeft, затем перепишите sum, string и makeString, задействовав эту
 * новую функцию.
 */
fun main() {
    println(makeString(listOf("Hola", "amigo", "como", "estas"), "__"))
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

//Решение
fun <T, U> foldLeft(list: List<T>, init: U, block: (U, T) -> U): U {
    tailrec fun foldLeft(list: List<T>, acc: U): U {
        return if (list.isEmpty())
            acc
        else
            foldLeft(list.tail(), block(acc, list.head()))

    }
    return foldLeft(list, init)
}

fun sum(list: List<Int>) = foldLeft(list, 0, Int::plus)

fun string(list: List<Char>) = foldLeft(list, "", String::plus)

fun <T> makeString(list: List<T>, delim: String) =
    foldLeft(list, "") { acc, elem -> if (acc.isEmpty()) "$elem" else "$acc$delim$elem" }