package recursion.exercise4

import recursion.exercise3.fibonacci

/**
 * Напишите версию функции makeString, использующую хвостовую рекурсию.
 * (Попробуйте не заглядывать в реализацию функции sum.)
 *
 * fun <T> makeString(list: List<T>, delim: String): String =
 *  when {
 *  list.isEmpty() -> ""
 *
 *  list.tail().isEmpty() -> "${list.head()}${makeString(list.tail(), delim)}"
 *
 *  else -> "${list.head()}$delim${makeString(list.tail(), delim)}"
 *  }
 */
fun main() {

}

//Решение
