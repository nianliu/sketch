package async.reactor

import async.reactor.SyncCreate.Companion.mutableStateGenerate
import reactor.core.publisher.Flux
import java.util.concurrent.atomic.AtomicLong

fun main(args: Array<String>) {

    mutableStateGenerate()
    SyncCreate.lastStateHook()
    SyncCreate.stateBasedGenerate()
    Thread.sleep(2000)
}

class SyncCreate {
    companion object {
        fun stateBasedGenerate() {
            Flux.generate<String, Int>(
                    { 0 }, // initial state
                    { state, sink ->
                        sink.next("state [$state], data [${System.currentTimeMillis()}]")
                        if (state == 10) sink.complete()
                        state + 1
                    })
                    .doOnNext { println(it) }
                    .subscribe()
        }

        fun mutableStateGenerate() {
            Flux.generate<String, AtomicLong>(
                    { AtomicLong() },
                    { state, sink ->
                        sink.next("state [$state], data [${System.currentTimeMillis()}]")
                        if (state.getAndIncrement() == 10L) sink.complete()
                        state
                    })
                    .doOnNext { println(it) }
                    .subscribe()
        }

        fun lastStateHook() {
            Flux.generate<String, AtomicLong>(
                    { AtomicLong() },
                    { state, sink ->
                        sink.next("state [$state], data [${System.currentTimeMillis()}]")
                        if (state.getAndIncrement() == 10L) sink.complete()
                        state
                    },
                    { state -> println("All data is generated, here we stop at state [$state]") })
                    .doOnNext { println(it) }
                    .subscribe()
        }
    }
}

