package inheritance;

import java.util.Arrays;
import java.util.Collections;

public class RunInheritanceMain {

    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        set.addAll(Arrays.asList("a","b","c"));
        set.add("d");
        System.out.println(set.getAddCount());

    }
}
