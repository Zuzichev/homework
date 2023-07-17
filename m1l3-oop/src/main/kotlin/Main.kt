package ru.otus.otuskotlin.productproperty.m1l3

import ru.otus.otuskotlin.productproperty.m1l3.MyClass.MyStatic.myAnyNumber

fun main() {
    println("Hello, module M1L3!")
    println("There is a static number: $myAnyNumber")
}


class MyClass{
    companion object MyStatic {
        const val myAnyNumber: Double = 0.0
    }

    var a: String = "aaaaa" // если декомпилить, то будут геттер+сеттер. У val только геттер

}
