package functions.exercise11

import functions.exercise10.curry

/**
 * Напишите функцию fun, которая меняет местами аргументы каррированной функции.
 */
fun main() {
    println(curry<Int, Int, Int>{ x, y -> x - y }(10)(20))
}

// Решение
fun <T, U, V> swapArgs(f: (T) -> (U) -> V): (U) -> (T) -> V =
    { a: U ->
        { b: T -> f(b)(a) }
    }
