package async.callback

class MyTimeUpdaterCallback : TimeUpdaterCallback {

    override fun updateTime(time: Long) {
        println("Updated time is $time")
    }

}