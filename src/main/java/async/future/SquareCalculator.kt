package async.future

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future


class SquareCalculator {

    private val executor = Executors.newSingleThreadExecutor()

    fun calculate(num: Int): Future<Int> {
        val submit = executor.submit(Callable<Int> {
            Thread.sleep(1000)
            num * num
        });

        return submit
    }
}