package reactive.callback

import java.util.*

class SystemTimer {

    var callbacks: MutableList<TimeUpdaterCallback> = ArrayList()

    fun registerCallback(callback: TimeUpdaterCallback) {
        callbacks.add(callback)
    }

    fun runUpdate() {
        callbacks.forEach { it.updateTime(System.currentTimeMillis()) }
    }

}


