package recursion.exercise2

/**
 *
 */
fun factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

/**
 *
 */
object Factor {
    val factorial: (Int) -> Int by lazy {
        { x -> if (x == 0) 1 else x * factorial(x - 1) }
    }
}