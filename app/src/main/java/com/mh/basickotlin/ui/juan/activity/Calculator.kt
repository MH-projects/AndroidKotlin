package com.mh.basickotlin.ui.juan.activity

class Calculator {

    fun suma(val1: Int, val2: Int): Int {
        return val1 + val2
    }
    fun resta(val1: Int, val2: Int): Int {
        return val1 - val2
    }
    fun mult(val1: Int, val2: Int): Int {
        return val1 * val2
    }
    fun div(val1: Int, val2: Int): Int {
        if (val2 == 0) {
            return 0
        }
        return val1 / val2
    }
}
