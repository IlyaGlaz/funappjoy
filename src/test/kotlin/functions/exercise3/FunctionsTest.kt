package functions.exercise3

import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest: StringSpec() {

    init {
        "add" {
            forAll { x: Int, y: Int ->
                println("$x $y")
                add(x)(y) == x + y
            }
        }
    }
}