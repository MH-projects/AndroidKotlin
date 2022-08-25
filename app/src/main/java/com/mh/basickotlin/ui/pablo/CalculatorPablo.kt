package com.mh.basickotlin.ui.pablo

class CalculatorPablo {

    fun convertStringToInt(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun plus(x: Int, y: Int): Int = x.plus(y)
    fun minus(x: Int, y: Int): Int = x.minus(y)
    fun times(x: Int, y: Int): Int = x.times(y)
    fun div(x: Int, y: Int): Int = x.div(y)
}
