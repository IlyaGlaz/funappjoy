package functions.exercise4

typealias IntUnaryOp = (Int) -> Int

/**
 * Напишите функцию-значение, объединяющую две функции, например
 * функции square и triple.
 */
fun main() {
    println(compose(square, triple)(2))
    println(curried(square)(triple)(2))
}

val square: IntUnaryOp = { it * it }
val triple: IntUnaryOp = { it * 3 }

// Решение
// Вариант с композицией функций
val compose: (IntUnaryOp, IntUnaryOp) -> IntUnaryOp =
    { x, y ->
        { z -> x(y(z)) }
    }

// Вариант с каррированием функций
val curried: (IntUnaryOp) -> (IntUnaryOp) -> IntUnaryOp =
    { x ->
        { y ->
            { z -> x(y(z)) }
        }
    }
