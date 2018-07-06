package mapping;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Builder
@Getter
public class MyKey {

    private String iCare1;
    private String iCare2;
    private int counter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return Objects.equals(iCare1, myKey.iCare1) &&
                Objects.equals(iCare2, myKey.iCare2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iCare1, iCare2);
    }

}
