package async.future

fun main(args: Array<String>) {
    val calculator = SquareCalculator();
    val future = calculator.calculate(2)

    Thread.sleep(100)
    println(future.get())
//    println(calculator.calculate(2).get(500, TimeUnit.MILLISECONDS))

}

