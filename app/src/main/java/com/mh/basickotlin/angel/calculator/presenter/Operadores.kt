/*
 * Operadores.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 11:19:17
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.calculator.presenter

class Operadores {

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
