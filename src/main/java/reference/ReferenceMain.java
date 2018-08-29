package reference;

public class ReferenceMain {

    public static void main(String[] args) {
        String toyota = new String("toyota");

        final Car car1 = new Car(toyota, 18);
        final Car car2 = new Car(toyota, 22);

        toyota = new String("honda");
        System.out.println(car1.getBrand());
        System.out.println(car2.getBrand());

        final Child c1 = new Child("c1");
        final Child c2 = new Child("c2");
        System.out.println(c1.getName());
        System.out.println(c2.getName());

    }

}
