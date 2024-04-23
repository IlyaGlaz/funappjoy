package recursion.exercise2

/**
 * Напишите рекурсивную функцию-значение factorial. Напомню, что
 * функция-значение – это функция, объявленная с  помощью ключевого
 * слова val:
 * val factorial: (Int) -> Int =
 * Так как это учебное упражнение, использование ссылки на функцию
 * будет считаться обманом
 *
 * fun factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
 */
fun main() {
    println(Factorial2.factorial(5))
}

//Решение
object Factorial1 {
    private lateinit var fact: (Int) -> Int
    init {
        fact = { n -> if (n <= 1) n else n * fact(n - 1) }
    }
    val factorial = fact
}

object Factorial2 {
    val factorial: (Int) -> Int by lazy {
        { n: Int ->
            if (n <= 1) n else n * factorial(n - 1)
        }
    }
}
