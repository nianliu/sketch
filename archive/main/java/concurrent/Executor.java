package concurrent;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Executor {

    private final int threadCount = 1 + 2 * Runtime.getRuntime().availableProcessors();
    //    private final int threadCount = 2;
    private static final int TIME_LIMIT_IN_SECONDS = 5;

    AtomicReference<String> stringAtomicReference;
    private ExecutorService executorService;
    private List<Callable<List<String>>> callables;
    private List<String> list;

    public Executor() {
        list = Collections.synchronizedList(new ArrayList<>());
        createExecutorService();
        Callable<List<String>> task1 = () -> task1("1");
        Callable<List<String>> task2 = () -> task2("2");
        Callable<List<String>> task4 = () -> task4("4");
        Runnable run1 = () -> taskA("1");

        callables = Arrays.asList(task4, task1, task2);
    }

    public void test() throws InterruptedException {
        execute(callables);
    }

    private void createExecutorService() {
        executorService = Executors.newFixedThreadPool(threadCount, new ThreadFactory() {
            private final AtomicInteger threadCount = new AtomicInteger();

            @Override
            public Thread newThread(@NotNull Runnable r) {
                final String threadName = String.format("Executor-%s", threadCount.getAndIncrement());
                return new Thread(r, threadName);
            }
        });
    }


    private void execute(List<Callable<List<String>>> callables) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(callables.size());
//        latch.countDown();
        long startTime = System.currentTimeMillis();

        callables.forEach(callable -> executorService.execute(() -> {
            try {
                callable.call();
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            } finally {
                latch.countDown();
            }
        }));

        boolean await;

        try {
            await = latch.await(TIME_LIMIT_IN_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Latch awaiting interrupted!");
            throw new RuntimeException(e);
        }

        final long stopTime = System.currentTimeMillis();

        System.out.println(list);
        System.out.format("await: %s%n", await);
        System.out.format("duration: %d ms%n", stopTime - startTime);
    }

    private void taskA(String a) {

    }

    private List<String> task1(String input) throws InterruptedException {
        System.out.println("task1" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(1);
        List<String> result = Arrays.asList("One", "Second", "Sleep");
        list.addAll(result);
        System.out.println(result);
        return result;
    }

    private List<String> task2(String input) throws InterruptedException {
        System.out.println("task2" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        List<String> result = Arrays.asList("Two", "Seconds", "Sleep");
        list.addAll(result);
        System.out.println(result);
        return result;
    }

    private List<String> task4(String input) throws InterruptedException {
        System.out.println("task4" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(4);
        List<String> result = Arrays.asList("Four", "Seconds", "Sleep");
        list.addAll(result);
        System.out.println(result);
        return result;
    }

}
