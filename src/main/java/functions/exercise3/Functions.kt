package functions.exercise3

typealias IntBinOp = (Int) -> (Int) -> Int

/**
 * Давайте попробуем определить функцию сложения двух целых чисел.
 * Применим функцию к первому целому числу и вернем другую функцию.
 *
 */
fun main() {
    println(add(2)(4))
    println(mult(-2)(2))
}

// Решение
val add: IntBinOp = { x -> { y -> x + y } }
val mult: IntBinOp = { x -> { y -> x * y } }
