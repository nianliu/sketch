package kt

fun main(args: Array<String>) {
    say("nian", "liu")
}

fun say(vararg worlds: String) {
    val list = listOf("hello", "this", "is", *worlds)
    println(list.joinToString(" "))
}