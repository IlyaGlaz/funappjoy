package functions.exercise4

import functions.exercise1.square
import functions.exercise1.triple
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest : StringSpec() {

    init {
        "curried" {
            forAll { x: Int ->
                curried(::square)(::triple)(x) == square(triple(x))
            }
        }
    }
}