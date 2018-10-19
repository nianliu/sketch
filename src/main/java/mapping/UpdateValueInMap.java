package mapping;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UpdateValueInMap {

    public static void main(String[] args) {
        final Map<Integer, Value> collect = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), i -> new Value()));

        final boolean prev = collect.get(0)
                .isUsed
                .getAndSet(true);

        final boolean current = collect.get(0).isUsed.get();

        System.out.println(prev);
        System.out.println(current);

        IntStream.range(0, 5)
                .boxed()
                .forEach(i-> collect.get(0).counter.getAndIncrement());

        manipulate(collect.get(0));
        System.out.println(collect.get(0).counter.get());
        System.out.println(collect.get(0).name);

    }

    private static class Value {
        private final AtomicInteger counter;
        private final AtomicBoolean isUsed;
        private String name;

        private Value() {
            counter = new AtomicInteger();
            isUsed = new AtomicBoolean();
            name = "nian";
        }

        public AtomicInteger getCounter() {
            return counter;
        }
    }

    private static void manipulate(Value v) {
        v.name = "xin";
    }

}
