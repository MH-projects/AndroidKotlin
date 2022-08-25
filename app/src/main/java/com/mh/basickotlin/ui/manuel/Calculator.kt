package com.mh.basickotlin.ui.manuel

class Calculator {

    fun convertStringToInt(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun suma(x: Int, y: Int): Int {
        return x.plus(y)
    }
}
