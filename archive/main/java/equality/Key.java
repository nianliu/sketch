package equality;

import org.jetbrains.annotations.NotNull;

public class Key implements Comparable<Key> {

    private final int foo;
    private final int bar;

    public Key(int foo, int bar) {
        this.foo = foo;
        this.bar = bar;
    }

    @Override
    public int compareTo(@NotNull Key k) {
        return Integer.compare(foo, k.foo);
    }
}
