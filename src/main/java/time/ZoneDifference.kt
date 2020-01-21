package time

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.Period
import java.time.temporal.TemporalUnit

fun main(args: Array<String>) {

    val localNow = LocalDateTime.now()
    val instantNow1 = Instant.now()
    val instantNow2 = Instant.from(instantNow1)
    val instantNow3 = instantNow1
    val plus1 = instantNow1.plus(Duration.ofDays(2))
    val plus2 = instantNow2.plus(Period.ofDays(2))
    val plus3 = instantNow3.plus(Duration.ofDays(2))
    println("hello")
}