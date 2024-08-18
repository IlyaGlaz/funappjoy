package recursion.exercise10

/**
 * Напишите обобщенную версию функции range, которая могла бы работать с  разными типами и  условиями. Поскольку понятие диапазона
 * (range) подходит только для чисел, назовите эту версию unfold. Вот как
 * выглядит сигнатура этой функции:
 * fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T>
 */
fun main() {
    println(unfold(1, { i -> i + 1 }, { it < 11 }))
}

//Решение
fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    val result: MutableList<T> = mutableListOf()
    var elem = seed

    while (p(elem)) {
        result.add(elem)
        elem = f(elem)
    }

    return result
}

