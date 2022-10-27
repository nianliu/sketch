package async.reactor

import reactor.core.publisher.Flux

fun main(args: Array<String>) {
    handle()

    Thread.sleep(2000)
}

fun handle() {
    val flux = Flux.range(0, 10);

    flux.map {
        if (it == 5) {
            throw RuntimeException("Oops...")
        }
        it
    }
            .subscribe({ println(it) },
                    { System.err.println("Error: ${it.message}") }
                    , { println("END") }
                    , { it.request(8) }
            )
}