package recursion.exercise16

/**
 * Oпределите функцию iterate, которая действовала бы как unfold, но вместо рекурсивного вызова самой себя
 * до выполнения некоторого условия она должна вызывать себя определенное число раз.
 */
fun main() {
    println(iterate(1, { i -> i + 1 }, 101))
}

//Решение
fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun iterate(acc: List<T>, seed: T): List<T> =
        if (acc.size < n)
            iterate(acc + seed, f(seed))
        else
            acc
    return iterate(listOf(), seed)
}

