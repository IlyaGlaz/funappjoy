package functions.exercise7

/**
 * Напишите функцию fun для частичного применения каррированной
 * функции двух аргументов к ее первому аргументу.
 */
fun main() {
    val firstPart = partial1<Double, Double, Double>(1.5) { x ->
        { y -> x * y }
    }
    println(firstPart(4.0))
}

// Решение
fun <A, B, C> partial1(a: A, f: (A) -> (B) -> C): (B) -> C = f(a)
