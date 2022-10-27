//package reflection
//
//import java.time.Instant
//import kotlin.reflect.KClass
//import kotlin.reflect.KProperty1
//import kotlin.reflect.full.memberProperties
//import kotlin.reflect.jvm.javaType
//
//fun main(args: Array<String>) {
//
//    Data::class.memberProperties
//            .forEach { reflect(it) }
//}
//
//
//fun <T, R : Any> reflect(prop: KProperty1<T, R?>) {
//    val javaClass1 = prop.returnType.javaClass as Class<R>
//    TypeCompare.compare(javaClass1)
//
//    val javaClass2 = (prop.returnType.classifier as KClass<*>).javaObjectType as Class<R>
//    TypeCompare.compare(javaClass2)
//
//    val javaClass3 = prop.returnType.javaType as Class<R>
//    TypeCompare.compare(javaClass3)
//
//    val kClass = prop.returnType.classifier as KClass<R>
//    compare(kClass)
//}
//
//
//fun <T:Any> compare(clz : KClass<T>) {
//    val get = mapOf(String::class to "STRING",
//            Int::class to "INT64",
//            Instant::class to "TIMESTAMP")
//            .get(clz)!!
//    println(get)
//}
//
//data class Data(val name: Int?, val time: Instant)
//
//
