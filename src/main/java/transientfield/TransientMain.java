package transientfield;

import java.io.*;

public class TransientMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Person person = new Person("nian", "liu", "nliu");
        ;
        try (final ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("person"))) {
            os.writeObject(person);
        }

        // reading from object
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("person"));
        Person person1 = (Person)in.readObject();

        System.out.println(person);
        System.out.println(person1);
    }
}
