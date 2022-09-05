package com.mh.basickotlin.manuel

import android.widget.Button

interface Animal { // QUE pero no el COMO
    fun comer()
}

class Perro : Animal {

    val alimentador = PresenterAnimal(this)

    init {
        alimentador.getComida("creoquetas")
    }

    override fun comer() {
        println("Comer croquetas")
    }
}

class Tiburon : Animal {

    val alimentador = PresenterAnimal(this)

    init {
        alimentador.getComida("peces")
    }

    override fun comer() {
        println("Comer peces")
    }
}

interface IPresenterAnimal {
    fun getComida(comida: String)
}

class PresenterAnimal(val interfaceCallback: Animal) : IPresenterAnimal {

    override fun getComida(comida: String) {
        if (comida == "croquetas") {
            // Ve a la tienda y compra croqu
        } else {
            // Ve al mar a pezcar
        }

        interfaceCallback.comer()
    }
}

interface IView {
    fun showMessage()
    fun showError()
    fun showAlert()
}

interface IActivity {
    fun showDate()
}

interface IPresenter {
    fun suma()
    fun getApi()
    fun getData()
}

class Presenter(val callback: IView? = null, val callbackActivity: IActivity? = null) : IPresenter {

    override fun suma() {
        callback?.showAlert()
    }

    override fun getApi() {
        callback?.showError()
    }

    override fun getData() {
        callbackActivity?.showDate()
    }
}

class ActivityClass : IActivity {

    var presenter: IPresenter = Presenter(null, this)

    init {
        presenter.getData()
    }

    override fun showDate() {
        TODO("Not yet implemented")
    }
}

class View : IView {

    var presenter: IPresenter = Presenter(this, null)

    init {
        presenter.suma()
        presenter.getApi()
    }

    override fun showMessage() {
        TODO("Not yet implemented")
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun showAlert() {
        TODO("Not yet implemented")
    }
}

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
