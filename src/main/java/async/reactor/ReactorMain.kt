package async.reactor

import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*
import reactor.core.publisher.Mono


fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3);

    val elements = ArrayList<Int>()

    Flux.fromIterable(ints)
            .delayElements(Duration.ofNanos(1))
            .doOnNext { println("I'm working on $it") }
            .log()
            .doOnComplete { println("I'm done here") }
            .subscribe { elements.add(it) }

    println("Got ${elements.size} elements")

    Mono.just(1)
            .doOnNext {  }
            .map { integer -> "foo" + integer!! }
            .or(Mono.empty())
            .subscribe({ println(it) })
}