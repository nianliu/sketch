package mapping;

import java.util.HashMap;
import java.util.Map;

public class MappingMain {

    public static void main(String[] args) {

        Map<MyKey, String> testMap = new HashMap<>();
        testMap.put(MyKey.builder().iCare1("a").iCare2("b").counter(1).build(), "1");
        testMap.put(MyKey.builder().iCare1("a").iCare2("b").counter(2).build(), "2");
        testMap.put(MyKey.builder().iCare1("a").iCare2("b").counter(3).build(), "3");
        testMap.put(MyKey.builder().iCare1("a").iCare2("b").counter(4).build(), "4");
        testMap.put(MyKey.builder().iCare1("a").iCare2("A").counter(4).build(), "4");


        System.out.println(testMap.size());
    }
}
