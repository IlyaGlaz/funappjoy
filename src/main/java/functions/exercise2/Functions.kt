package functions.exercise2

/**
 * Преобразуйте функцию compose в полиморфную функцию, использовав
 * параметры типов.
 */
fun main() {
    val squareOfTriple = compose(::square, ::triple)
    println(squareOfTriple(2))
}

fun square(n: Int) = n * n
fun triple(n: Int) = n * 3

// Решение
fun <T, U, V> compose(first: (U) -> V, second: (T) -> U): (T) -> V = { x -> first(second(x)) }
