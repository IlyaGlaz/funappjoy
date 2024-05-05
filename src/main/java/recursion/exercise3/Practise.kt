package recursion.exercise3

import java.math.BigInteger

/**
 *
 */
fun fibonacci1(n: Int): Int =
    if (n <= 1)
        1
    else
        fibonacci1(n - 1) + fibonacci1(n - 2)

/**
 * Цикл
 */
fun main() {
    println(fibonacci2(5))
}

fun fibonacci2(n: Int): MutableList<Int> {
    val acc = ArrayList<Int>()

    var first = 0
    var second = 0
    var current = 0
    for (i in 0..n) {
        if (i == 0) {
            acc += 1
        } else if (i == 1) {
            acc += 1
            first = 1
            second = 1
        } else {
            current = first + second
            acc += current
            first = second
            second = current
        }
    }

    return acc
}

/**
 * Сорекурсия
 */
tailrec fun fibonacci3(first: BigInteger, second: BigInteger, n: BigInteger): BigInteger =
    when {
        n == BigInteger.ZERO -> BigInteger.ONE
        n == BigInteger.ONE -> first + second
        else -> fibonacci3(second, first + second, n - BigInteger.ONE)
    }