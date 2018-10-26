package reactive.callback

/**
 * Update timer every second via callback functions
 */
fun main(args: Array<String>) {
    val timer = SystemTimer()
    val myCallback = MyTimeUpdaterCallback()
    timer.registerCallback(myCallback)


    for (i in 1..10) {
        Thread.sleep(1000)
        timer.runUpdate()
    }

}

