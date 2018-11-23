package functional.programming.patterns.advance;

import java.util.function.BiFunction;

public class MovieJava {

    enum Type {

        REGULAR(PriceService::computeRegularPrice),
        NEW_REALEASE(PriceService::computeNewReleasePrice),
        CHILDREN(PriceService::computeChildrenPrice),
        ELDERS(PriceService::computeEldersPrice);

        public final BiFunction<PriceService, Integer, Integer> priceAlgo;

        Type(final BiFunction<PriceService, Integer, Integer> priceAlgo) {
            this.priceAlgo = priceAlgo;
        }

    }

    private final Type type;

    public MovieJava(final Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
