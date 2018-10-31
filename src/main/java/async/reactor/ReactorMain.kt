package async.reactor

import reactor.core.publisher.Flux
import java.time.Duration


fun main(args: Array<String>) {
//    val ints = listOf(1, 2, 3);
//
//    val elements = ArrayList<Int>()
//
//    Flux.fromIterable(ints)
//            .delayElements(Duration.ofNanos(1))
//            .doOnNext { println("I'm working on $it") }
//            .log()
//            .doOnComplete { println("I'm done here") }
//            .subscribe { elements.add(it) }
//
//    println("Got ${elements.size} elements")
//
//    Mono.just(1)
//            .doOnNext {  }
//            .map { integer -> "foo" + integer!! }
//            .or(Mono.empty())
//            .subscribe({ println(it) })
//
//    Flux.fromIterable(ints)
//            .timeout(Duration.ofMillis(200))
//            .onErrorResume { Flux.empty() }
//            .map { "number $it" }
//            .take(2)

    Flux.interval(Duration.ofMillis(1))
            .limitRate(20)
            .map { System.currentTimeMillis() }
            .doOnNext { println("he") }
            .doOnComplete { println("end") }
            .take(Duration.ofMillis(3000))
            .subscribe()


}

fun basicGenerator() {
    Flux.generate<String, Int>(
            { 0 },
            { state, sink ->
                println("start state = $state")
                sink.next("state [$state], data [${System.currentTimeMillis()}]")
                if (state == 10) sink.complete()
                state + 1
            })
            .subscribe()
}

fun generatorWithAtomic() {
    Flux.generate<String, Int>(
            { 0 },
            { state, sink ->
                println("start state = $state")
                sink.next("state [$state], data [${System.currentTimeMillis()}]")
                if (state == 10) sink.complete()
                state + 1
            })
            .subscribe()
}