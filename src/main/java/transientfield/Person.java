package transientfield;

import lombok.ToString;

import java.io.Serializable;


/**
 *  Do not serialize Transient field, you will see full name is null after deserialize.
 */
@ToString
public class Person implements Serializable {

    private final String firstName;
    private final String lastName;
    private transient final String fullName;

    public Person(String firstName, String lastName, String fullName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
    }

}
