package com.mh.basickotlin.ui.angel

class Operators {

    fun conString(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun plus(a: Int, b: Int): Int {
        return a.plus(b)
    }

    fun less(a: Int, b: Int): Int {
        return a.minus(b)
    }

    fun by(a: Int, b: Int): Int {
        return a.times(b)
    }
    fun split(a: Int, b: Int): Int{
        return a.div(b)
    }
}
