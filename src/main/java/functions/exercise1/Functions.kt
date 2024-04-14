package functions.exercise1

/**
 * Напишите функцию compose (объявив ее с ключевым словом fun), которая
 * объединяет функции целочисленного аргумента Int, возвращающие Int.
 */
fun main() {
    val squareOfTriple = compose(::square, ::triple)
    println(squareOfTriple(2))
}

fun square(n: Int) = n * n
fun triple(n: Int) = n * 3

// Решение
fun compose(first: (Int) -> Int, second: (Int) -> Int): (Int) -> Int = { x -> first(second(x)) }
