package functional.programming.patterns.basic

import java.util.function.Function

class Movie(val type: Type) {

    enum class Type(val priceAlgo: Function<Int, Int>) {
        REGULAR(Function { days -> days + 1 }),
        NEW_RELEASE(Function { days -> days * 2 })
    }

}