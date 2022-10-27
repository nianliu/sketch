package async.completable

import java.util.*

class JobProvider {

    val list = listOf("Student", "Teacher", "Doctor", "Farmer")

    fun getJob(id: Int): String {
        val sleepSecs = Random().nextInt(5)
        println("Sleeping $sleepSecs seconds to get job for $id")
        Thread.sleep(sleepSecs * 1000L)
        return list[id]
    }

}