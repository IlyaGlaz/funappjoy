package functions.exercise5

import functions.exercise1.square
import functions.exercise1.triple
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest : StringSpec() {

    init {
        "higherCompose" {
            forAll { x: Int ->
                higherCompose<Int, Int, Int>()(::square)(::triple)(x) == square(triple(x))
            }
        }
    }
}