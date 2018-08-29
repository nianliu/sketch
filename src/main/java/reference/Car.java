package reference;

import lombok.Getter;

@Getter
public class Car {

    private final String brand;
    private final long mileAge;

    public Car(String brand, long mileAge) {
        this.brand = brand;
        this.mileAge = mileAge;
    }
}
