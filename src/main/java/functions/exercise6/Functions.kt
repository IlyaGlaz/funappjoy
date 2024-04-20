package functions.exercise6

typealias IntUnaryOp = (Int) -> Int

/**
 * Напишите функцию higherAndThen, объединяющую функции в аргументах
 * в обратном порядке, т. е. вызов higherCompose(f, g) эквивалентен вызову
 * higherAndThen(g, f).
 */
fun main() {
    println(higherAndThen<Int, Int, Int>()(square)(triple)(2))
}

val square: IntUnaryOp = { it * it }
val triple: IntUnaryOp = { it * 3 }

// Решение
fun <T, U, V> higherAndThen(): ((T) -> U) -> ((U) -> V) -> (T) -> V =
    { f: (T) -> U ->
        { g: (U) -> V ->
            { x: T -> g(f(x)) }
        }
    }

