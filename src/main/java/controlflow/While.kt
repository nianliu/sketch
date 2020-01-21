package controlflow

fun main(args: Array<String>) {

    val toMap = emptyList<Int>()
            .map { it to it.toString() }
            .toMap()

    println(toMap)
    println(toMap.values.size)
    println(toMap.values.isEmpty())



//    val collect = collect()
//    print(collect)
}

fun collect(): List<Int> {
    val collector = mutableListOf<Int>()
    var i = 1
    loop@ while (i < 10) {
        when (i) {
            5 -> break@loop
            else -> collector.add(i)
        }

        i++
    }
    return collector.toList()
}