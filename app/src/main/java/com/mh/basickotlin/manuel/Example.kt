package com.mh.basickotlin.manuel

import android.widget.Button

fun main() {
    val a = 3
    val b = 5
    var x = 0

    var objeto: Any? = null

    val type = when (objeto) {
        1 -> "Entero 1"
        "Hola" -> "Saludo"
        is Long -> "Long"
        in 0..10 -> "Entre 0 y 10"
        else -> "Default"
    }

    for (i in 0..10) {
        println("Valor: $i")
    }

    for (i in 4 downTo 1) {
        println("Valor: $i")
    }

    for (i in 0..100 step 10) {
        println("Valor: $i")
    }

    for (i in 0 until 10) {
        println("Valor: $i")
    }

    for (c in "Kotlin") {
        println("$c")
    }

    val array = ArrayList<String>()

    fun operaciones(x: Int, y: Int) {
        fun resta(x: Int, y: Int) {
            println("Resta: ${x - y}")
        }

        fun suma(x: Int, y: Int) {
            println("Suma: ${x + y}")
        }
        resta(x, y)
    }

    x = 5
    val numero = when {
        x == 0 -> 0
        x in 0..10 -> 2
        else -> -1
    }

    val list = arrayListOf(1, 2, 3, 4, 5)

    fun opera(lista: List<Int>, valor: Int, funcion: (Int, Int) -> Int): List<Int> {
        val result = arrayListOf<Int>()
        for (item in lista) {
            result.add(funcion(item, valor))
        }
        return result
    }

    // val funcion = fun(x: Int, y: Int): Int = x + y
    // val lista = opera(list, 2, funcion)
    // val lista = opera(list, 2, fun(x, y): Int = x + y)

    val funcion = { x: Int, y: Int -> x + y }
    // val lista = opera(list, 2, funcion)
    val lista = opera(list, 2) { x, y ->
        x + y
    }

    println("List: $lista")

    val button: Button

    /* button.setOnClickListener {
        // TODO
    }*/

    println("====> FOR 10 - 0")
    for (i in 10 downTo 0) {
        println("Value: $i")
    }

    fun suma(x: Int, y: Int) = run { println("Suma: ${x + y}"); x + y }
}

class Example
