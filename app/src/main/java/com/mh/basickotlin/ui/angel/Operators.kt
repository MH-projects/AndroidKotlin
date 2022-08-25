package com.mh.basickotlin.ui.angel

class Operators {

    fun conString(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun plus(a: Int, b: Int): Int {
        return a.plus(b)
    }
}
