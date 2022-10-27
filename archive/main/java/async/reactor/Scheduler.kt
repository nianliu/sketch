package async.reactor

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers

/**
 *  single:     a one worker thread scheduler
 *  immediate:  a scheduler that computes the stream in the thread where the call to the method configuring it is done.
 *  parallel:   a scheduler that has as many workers as your CPU has cores (or threads if supporting hyper threading). The method it uses to get the amount of workers to use is Runtime.getRuntime().availableProcessors()
 *  elastic:    a scheduler that dynamically creates threads when needed, with no up limit. A thread is released after 60 non-working seconds.
 *  https://medium.com/@cheron.antoine/reactor-java-4-how-to-take-control-over-the-execution-of-mono-and-flux-ead31dc066
 */
fun main(args: Array<String>) {
    complexCase()
}


fun subscribeOnSameThread() {
    Flux.range(1, 3)
            .map { identityWithThreadLogging(it, "map1") }
            .flatMap {
                Mono.just(it).map { identityWithThreadLogging(it, "mono") }
            }
            .subscribeOn(Schedulers.parallel())
            .subscribe {
                identityWithThreadLogging(it, "subscribe")
                System.out.println(it)
            }
}

fun subscribeOnDiffThread() {
    Flux.range(1, 3)
            .map { identityWithThreadLogging(it, "map1") }
            .flatMap {
                Mono.just(it).map { identityWithThreadLogging(it, "mono") }.subscribeOn(Schedulers.single())
            }
            .subscribeOn(Schedulers.parallel())
            .subscribe {
                identityWithThreadLogging(it, "subscribe")
                System.out.println(it)
            }
}

fun complexCase() {
    Flux.range(1, 4)
            .subscribeOn(Schedulers.immediate())
            .map { identityWithThreadLogging(it, "map1") }
            .flatMap {
                when (it) {
                    1 -> createMonoOnScheduler(it, Schedulers.parallel())
                    2 -> createMonoOnScheduler(it, Schedulers.elastic())
                    4 -> createMonoOnScheduler(it, Schedulers.single())
                    else -> Mono.error<Int>(RuntimeException("Unknown number $it!")).subscribeOn(Schedulers.newSingle("error-thread"))
                }
            }
            .map { identityWithThreadLogging(it, "map2") }
            .subscribe(
                    {
                        println(identityWithThreadLogging(it, "subscribe"))
                    }
                    ,
                    {
                        System.err.println(identityWithThreadLogging(it, "subscribe, error").message)
                    }
                    , { println("COMPLETE") }
                    , { println("END"); it.request(2) }
            )
}

private fun <T> identityWithThreadLogging(el: T, operation: String): T {
    println(operation + " -- " + el + " -- " + Thread.currentThread().name)
    return el
}

private fun <T> createMonoOnScheduler(value: T, scheduler: Scheduler): Mono<T> {
    return Mono.just(value)
            .map { identityWithThreadLogging(it, "mono") }
            .subscribeOn(scheduler)
}