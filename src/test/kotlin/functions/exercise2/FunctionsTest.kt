package functions.exercise2

import functions.exercise1.square
import functions.exercise1.triple
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest : StringSpec() {

    init {
        "compose" {
            forAll { x: Int ->
                compose(::square, ::triple)(x) == square(triple(x))
            }
        }
    }
}