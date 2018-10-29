package kt


/**
 *  qualified return
 */
fun main(args: Array<String>) {
    explicitReturn()
    implicitReturn()
    returnFromAnonymousFunction()
    actAsBreak()
}

fun explicitReturn() {
    listOf(1, 2, 3, 4, 5)
            .forEach lit@{
                if (it == 4) return@lit
                println(it)
            }
    print(" done with explicit label")
}

fun implicitReturn() {
    listOf(1, 2, 3, 4, 5)
            .forEach {
                if (it == 4) return@forEach
                println(it)
            }
    println(" done with implicit label")
}

fun returnFromAnonymousFunction() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // local return to the caller of the anonymous fun, i.e. the forEach loop
        println(value)
    })
    println(" done with anonymous function")
}

fun actAsBreak() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            println(it)
        }
    }
    println(" done with nested loop")
}