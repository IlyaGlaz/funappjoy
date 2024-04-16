package functions.exercise5

typealias IntUnaryOp = (Int) -> Int

/**
 * Напишите полиморфную версию функции compose.
 */
fun main() {
    println(higherCompose<Int, Int, Int>()(square)(triple)(2))
}

val square: IntUnaryOp = { it * it }
val triple: IntUnaryOp = { it * 3 }

// Решение
fun <T, U, V> higherCompose(): ((U) -> V) -> ((T) -> U) -> (T) -> V =
    { f ->
        { g ->
            { x -> f(g(x)) }
        }
    }

