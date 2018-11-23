package functional.programming.patterns.advance

import java.util.function.BiFunction

data class MovieKt(val type: Type) {
    enum class Type constructor(val priceAlgo: BiFunction<PriceService, Int, Int>) {
        NEW_RELEASE(BiFunction { t, u -> t.computeRegularPrice(u) });
    }
}