package com.mh.basickotlin.josue

class Operation {

    fun convertStringToInt(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun suma(numUno: Int, numDos: Int): Int {
        return numUno.plus(numDos)
    }
    fun resta(numUno: Int, numDos: Int): Int {
        return numUno.minus(numDos)
    }
    fun multi(numUno: Int, numDos: Int): Int {
        return numUno.times(numDos)
    }
    fun div(numUno: Int, numDos: Int): Int {
        return numUno.div(numDos)
    }
}
