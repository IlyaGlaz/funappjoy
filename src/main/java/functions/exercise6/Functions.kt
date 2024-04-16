package functions.exercise6

typealias IntUnaryOp = (Int) -> Int

/**
 * Напишите функцию higherAndThen, объединяющую функции в аргументах
 * в обратном порядке, т. е. вызов higherCompose(f, g) эквивалентен вызову
 * higherAndThen(g, f).
 */
fun main() {
    println(curried<Int, Int, Int>()(square)(triple)(2))
}

val square: IntUnaryOp = { it * it }
val triple: IntUnaryOp = { it * 3 }

// Решение
fun <T, U, V> curried(): ((U) -> V) -> ((T) -> U) -> (T) -> V =
    { f ->
        { g ->
            { x -> f(g(x)) }
        }
    }

