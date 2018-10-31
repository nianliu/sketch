package async.completable

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.function.Supplier


fun main(args: Array<String>) {

    val executor = Executors.newSingleThreadExecutor()
    val nameProvider = NameProvider()
    val jobProvider = JobProvider()


    val future = CompletableFuture.supplyAsync(Supplier { nameProvider.getName(1) }, executor)
            .thenApply { "[$it]" }
            .thenAccept { println("I received $it") }
            .thenRun { println("END") }

    val f2 = CompletableFuture.supplyAsync(Supplier { nameProvider.getName(2) }, executor)
            .thenCompose { name -> CompletableFuture.supplyAsync(Supplier { "$name has job as " + jobProvider.getJob(2) }, executor) }
            .thenAcceptAsync { println(it) }

    println(future.get())

    f2.get()

}

fun execute(): Future<String> {
    val completableFuture = CompletableFuture<String>()

    Executors.newSingleThreadExecutor().submit<Any> {
        Thread.sleep(2000)
        completableFuture.complete("Hello")
        null
    }

    return completableFuture
}