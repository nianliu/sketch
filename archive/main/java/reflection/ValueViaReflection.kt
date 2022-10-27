package reflection

import java.math.BigDecimal
import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {

    val names = Dummy::class.memberProperties.map { it.name }
    println(names)

    val dummy = Dummy("nian", BigDecimal("1.99"), true)
    val values = dummy::class.memberProperties.map { it.getter.call(dummy) }
    println(values)
}

data class Dummy(val name: String, val amount: BigDecimal, val success: Boolean)
