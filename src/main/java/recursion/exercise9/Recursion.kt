package recursion.exercise9

/**
 * Используя цикл, напишите функцию, которая конструирует список на
 * основе начального значения, границы и функции x -> x + 1 и имеет следующую сигнатуру:
 *  fun range(start: Int, end: Int): List<Int>
 * Назовите эту функцию range.
 */
fun main() {
    println(range(20, 41))
}


//Решение
fun range(start: Int, end: Int): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    var counter = start

    while (counter < end) {
        result.add(counter)
        counter++
    }

    return result
}
