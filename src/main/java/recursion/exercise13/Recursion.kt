package recursion.exercise13

/**
 * Напишите рекурсивную версию unfold.
 */
fun main() {
    println(unfold(1, { i -> i + 1 }, { it < 11 }))
}

//Решение
fun <T> prepend(list: List<T>, elem: T): List<T> = listOf(elem) + list

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> =
    if (p(seed))
        prepend(unfold(f(seed), f, p), seed)
    else
        listOf()

