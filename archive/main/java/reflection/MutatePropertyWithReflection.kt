package reflection

import java.io.Serializable
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {

    val to = TestObject("nian", 18)

    to::class.memberProperties
            .map { it.getter.call(to) }
            .forEach { println(it) }

    val s = TestObject::class.memberProperties.map { it.name }.joinToString(",")
    println(s)


    doSome(Mode.TEST.kClass, to)

    println(Type.S.kClass.clazz<String>())

}

private inline fun <reified T : Any> KClass<*>.clazz(): KClass<T> {
    return T::class
}

inline fun <reified T : Serializable> doSome(kClass: KClass<T>, obj: Any) {
    T::class.memberProperties
            .map { it.getter.call(obj) }
            .forEach { println(it) }
}


data class TestObject(
        val name: String,
        val age: Int
) : Serializable

data class DummyObject(
        val nameD: String,
        val ageD: Int
) : Serializable

enum class Mode(val kClass: KClass<Serializable>) {
    TEST(TestObject::class as KClass<Serializable>),
    DUMMY(DummyObject::class as KClass<Serializable>)
}


enum class Type(val kClass: KClass<*>) {
    S(String::class),
    I(Int::class)
}