package functions.exercise10

/**
 * Напишите функцию, возвращающую каррированную версию функции
 * (A, B) -> C.
 */
fun main() {
    println(curry<Int, Int, Int>{ x, y -> x + y }(20)(40))
}

// Решение
fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
    { a: A ->
        { b: B -> f(a, b) }
    }

