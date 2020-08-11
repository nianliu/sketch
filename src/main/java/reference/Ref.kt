package reference

fun main(args: Array<String>) {

    val l1 = mutableListOf(1, 2, 3)
    val l2 = l1
    println(l2)
    l2.removeAt(0)
    println(l2)
    println(l1)

}

