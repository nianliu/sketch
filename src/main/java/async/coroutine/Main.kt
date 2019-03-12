package async.coroutine

import kotlinx.coroutines.*


fun main(args: Array<String>) = runBlocking {
    withTimeout(111, {

    })
    val thread = GlobalScope.launch {
        // launch new coroutine in background and continue
        delay(2000)
        println("World!") // print after delay
    }
    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(10000L) // block main thread for 2 seconds to keep JVM alive
    println("Main thread dead")
    thread.join()
}