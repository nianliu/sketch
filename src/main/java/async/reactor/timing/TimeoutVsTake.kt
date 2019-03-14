package async.reactor.timing

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration
import java.time.LocalDateTime


fun main(args: Array<String>) {
    val result = Flux.just(2, 4)
            .withStatistics(1)
            .parallel()
            .runOn(Schedulers.elastic())
            .map { delay(it) }
            .sequential()
            .withStatistics(3)
            .take(Duration.ofMillis(3000))
//            .timeout(Duration.ofMillis(3000), Flux.empty())
            .collectList()
            .block()
    println(" Result : $result")
}

private fun <T> Flux<T>.withStatistics(id: Int): Flux<T> {
    return this.doOnSubscribe { subscribe(id) }
            .doOnNext { next(id, it) }
            .doOnComplete { complete(id) }
            .doOnCancel { cancel(id) }
            .doOnError { error(id) }
}

private fun <T> next(id: Int, data: T) {
    println("[${LocalDateTime.now()}] [$id] next [$data] ")
}

private fun complete(id: Int) {
    println("[${LocalDateTime.now()}] [$id] complete")
}

private fun cancel(id: Int) {
    println("[${LocalDateTime.now()}] [$id] cancel")
}

private fun error(id: Int) {
    println("[${LocalDateTime.now()}] [$id] error")
}

private fun subscribe(id: Int) {
    println("[${LocalDateTime.now()}] [$id] subscribe")
}

private fun delay(number: Int): Int {
    println("[${LocalDateTime.now()}] waiting for $number seconds")
    Thread.sleep(number * 1000L)
    println("[${LocalDateTime.now()}] finished waiting for $number seconds")
    if (number % 2 == 0) {
        return number
    } else {
        throw RuntimeException("I don't like it!!!!")
    }
}