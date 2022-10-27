package async.reactor.timing

import com.google.common.base.Stopwatch
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDateTime


fun main(args: Array<String>) {
    val clock1 = Stopwatch.createUnstarted()
    val clock2 = Stopwatch.createUnstarted()
    val clock3 = Stopwatch.createUnstarted()

    val take = Mono.fromCallable<Int> { delayedNumber(2) }
            .withStatistics(1, clock1)
//            .onErrorResume { Mono.empty() }
            .compose {
                it.flatMap {
                    Mono.just(it)
                            .map { delayedNumber(it + 1) }
                            .withStatistics(2, clock2)
                }
            }
            .doOnError {
                it
            }
            .onErrorResume { Mono.empty() }
            .withStatistics(3, clock3)
//            .take(Duration.ofMillis(200))
//            .timeout(Duration.ofMillis(2500),Mono.empty())

            .timeout(Duration.ofMillis(3500), Mono.empty())
            .block()
    println(" final " + (take))
}

private fun <T> Mono<T>.withStatistics(id: Int, clock: Stopwatch): Mono<T> {
    return this.doOnSubscribe { subscribe(id, clock) }
            .doOnSuccess { complete(id, clock) }
            .doOnCancel { cancel(id, clock) }
            .doOnError { error(id, clock) }
}

private fun complete(id: Int, clock: Stopwatch) {
    println("[$id] complete time ${LocalDateTime.now()}")
//    clock.stop()
}

private fun cancel(id: Int, clock: Stopwatch) {
    println("[$id] cancel time ${LocalDateTime.now()}")
//    clock.stop()
}

private fun error(id: Int, clock: Stopwatch) {
    println("[$id] error time ${LocalDateTime.now()}")
//    clock.stop()
}

private fun subscribe(id: Int, clock: Stopwatch) {
    println("[$id] subscribe time ${LocalDateTime.now()}")
    clock.start()
}

private fun delayedNumber(number: Int): Int {
    Thread.sleep(number * 1000L)
    println("waiting for $number seconds")
    if (number % 2 == 0) {
        return number
    } else {
        throw RuntimeException("I don't like it!!!!")
    }
}