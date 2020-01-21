package time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeMain {

    public static void main(String[] args) {
        String a = "9/01/2019 12:05:48";
        LocalDateTime parse = LocalDateTime.parse(a, DateTimeFormatter.ofPattern("d/MM/yyy H:mm:ss"));


        String now1 = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String now2 = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(now1);
        System.out.println(now2);

    }

}
