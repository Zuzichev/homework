import kotlin.reflect.KClass

fun <T> variant1(klass: KClass<*>) {
    println(klass.java)
}

inline fun <reified T> variant2() {
    println(T::class.java)
}