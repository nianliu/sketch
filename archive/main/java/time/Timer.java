package time;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class Timer {

    public static void main(String[] args) throws InterruptedException {
        Stopwatch clock = Stopwatch.createStarted();
        Thread.sleep(1000l);
        System.out.println(clock.elapsed(TimeUnit.MILLISECONDS));
        clock.reset().start();
        Thread.sleep(1000l);
        System.out.println(clock.elapsed(TimeUnit.MILLISECONDS));
    }
}
