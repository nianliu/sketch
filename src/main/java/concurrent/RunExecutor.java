package concurrent;

public class RunExecutor {

    public static void main(String[] args) throws InterruptedException {
        final int i = 1 / 0;
        Executor ex = new Executor();
        ex.test();

    }
}
