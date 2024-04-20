package functions.exercise8

/**
 * Напишите функцию fun для частичного применения каррированной
 * функции двух аргументов к ее второму аргументу
 */
fun main() {
//    val firstPart = functions.exercise7.partial1<Double, Double, Double>(3.0) { x ->
//        { y -> x * y }
//    }
//    println(firstPart(4.0))
}

// Решение
fun <A, B, C> partialB(b: B, f: (A) -> (B) -> C): (A) -> C = { a: A -> f(a)(b) }
