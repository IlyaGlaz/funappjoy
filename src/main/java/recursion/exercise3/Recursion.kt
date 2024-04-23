package recursion.exercise3

import java.math.BigInteger

/**
 * Создайте версию функции fibonacci, реализующую хвостовую рекурсию.
 *
 * fun fibonacci(number: Int): Int =
 *  if (number == 0 || number == 1)
 *  1
 *  else
 *  fibonacci(number - 1) + fibonacci(number - 2)
 */
fun main() {
    println(fibonacci(10_000))
}

//Решение
fun fibonacci(x: Int): BigInteger {
    tailrec fun fib(val1: BigInteger, val2: BigInteger, x: BigInteger): BigInteger =
        when {
            (x == BigInteger.ZERO) -> BigInteger.ONE
            (x == BigInteger.ONE) -> val1 + val2
            else -> fib(val2, val1 + val2, x - BigInteger.ONE)
        }
    return fib(
        BigInteger.ZERO, BigInteger.ONE,
        BigInteger.valueOf(x.toLong())
    )
}
