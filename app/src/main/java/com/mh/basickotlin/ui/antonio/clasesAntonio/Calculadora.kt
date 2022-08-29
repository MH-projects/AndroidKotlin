package com.mh.basickotlin.ui.antonio.clasesAntonio

class Calculadora {

    fun convertirStringAInt(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun suma(x: Int, y: Int): Int {
        return x.plus(y)
    }

    fun resta(x: Int, y: Int): Int {
        return x.minus(y)
    }

    fun multi(x: Int, y: Int): Int {
        return x.times(y)
    }

    fun div(x: Int, y: Int): Int {
        if (y == 0){
            return 0
        }else {
            return x.div(y)
        }
    }
}