package async.extension


fun main(args: Array<String>) {
    hey()

    NUMBER.andhello()
}

val NUMBER = {
    1

}

fun hey() {
    ::a.andhello()
}

fun a(): Int {
    return 1
}


fun (() -> Int).andhello() {
    this()
    println("abc")
}