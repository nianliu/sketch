package reflection;

public class TypeCompare {

    static <T> void compare(Class<T> clazz) {

        if (clazz == String.class) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
