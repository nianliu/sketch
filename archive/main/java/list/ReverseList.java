package list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.ListIterator;

public class ReverseList {

    public static void main(String[] args) {
        final ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        final ListIterator<Integer> integerListIterator = integers.listIterator(integers.size());
        while (integerListIterator.hasPrevious()) {
            System.out.println(integerListIterator.previous());
        }
    }

}
