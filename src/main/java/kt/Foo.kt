package kt

fun main(args: Array<String>) {
    val a = 1           // immutable object
    var b: Int = 2;     // mutable object
    val c = cal(a, b, "sum")
    println(c)
    println(describe("something"))
    nul()
    typeCheck("hello")
    typeCheck(1)
}

fun cal(a: Int, b: Int, ops: String) = if (ops == "sum") {
    println("$a + $b")
    a + b
} else {
    println("$a - $b")
    a - b
}


fun nul() {
    val listWithNulls: List<String?> = listOf("Kotlin", "9", null)

    listWithNulls.filterNotNull()
            .forEach {
                println(it)
            }

    for (item in listWithNulls) {
        val npeLength = item!!.length  // throw null pointer

        item?.let { println("Only print non-null value: $it") } // prints A and ignores null

        val l = item?.length ?: -1  // default if null
        println("Item length is $l")

        val aInt: Int? = item as? Int // safe cast, null if failed
        println("A int is $aInt")

        val s = item ?: throw IllegalStateException("I got a null!")  // exception as right hand side

    }

}

fun typeCheck(obj: Any): Int? {
    if (obj is String) {
        println("I found a string!")
        return obj.length
    } else {
        return null
    }
}

fun describe(obj: Any): String = when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a string"
    else -> "Unknown"
}