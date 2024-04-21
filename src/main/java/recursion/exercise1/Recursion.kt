package recursion.exercise1

/**
 * Реализуйте сорекурсивную функцию add, складывающую положительные целые числа. В реализации функции add не должны использоваться
 * операторы плюс (+) и минус (–), допускаются только две функции:
 * fun inc(n: Int) = n + 1
 * fun dec(n: Int) = n - 1
 * Вот сигнатура функции:
 * fun add(a: Int, b: Int): Int
 */
fun main() {
    println(add(1_000_000, 1_000_000))
}

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

//Решение
tailrec fun add(a: Int, b: Int): Int = if (a == 0) b else add(dec(a), inc(b))
