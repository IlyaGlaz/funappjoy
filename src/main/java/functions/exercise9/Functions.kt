package functions.exercise9

/**
 * Преобразуйте следующую функцию в каррированную версию:
 * fun <A, B, C, D> func(a: A, b: B, c: C, d: D): String = "$a, $b, $c, $d"
 */
fun main() {
    println(curried<Int, Int, Int, Int>()(1)(5)(15)(50))
}

// Решение
fun <A, B, C, D> curried() =
    { a: A ->
        { b: B ->
            { c: C ->
                { d: D ->
                    "$a, $b, $c, $d"
                }
            }
        }
    }

