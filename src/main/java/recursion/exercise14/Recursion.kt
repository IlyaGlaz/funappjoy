package recursion.exercise14

/**
 * Можно ли переписать эту функцию и реализовать в ней хвостовую рекурсию?
 * Попробуйте ответить на этот вопрос, основываясь на теоретических выкладках,
 * а потом практически.
 */
fun main() {
    println(unfold(1, { i -> i + 1 }, { it < 11 }))
}

//Решение
fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun unfold(acc: List<T>, seed: T): List<T> =
        if (p(seed))
            unfold(acc + seed, f(seed))
        else
            acc

    return unfold(listOf(), seed)
}
