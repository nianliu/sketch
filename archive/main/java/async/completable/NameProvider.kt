package async.completable

import java.util.*

class NameProvider {

    val list = listOf("Nian", "Xin", "Kong", "Qi")

    fun getName(id: Int): String {
        val sleepSecs = Random().nextInt(5)
        println("Sleeping $sleepSecs seconds to get name for $id")
        Thread.sleep(sleepSecs * 1000L)
        return list[id]
    }

}