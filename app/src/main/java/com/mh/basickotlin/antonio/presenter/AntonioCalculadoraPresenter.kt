package com.mh.basickotlin.antonio.presenter

import com.mh.basickotlin.antonio.model.Digitos
import com.mh.basickotlin.antonio.model.Operadores


class AntonioCalculadoraPresenter (
    private val callBackView: AntonioCalculadorContract.view
) : AntonioCalculadorContract.presenter {

    private var digit1 = ""
    private var digit2 = ""
    private var operador = ""

    private var autoResult = false

    private fun setOP() {
        callBackView.setOP("$digit1 $operador $digit2")
        if (autoResult) {
            result()
        }
    }

    override fun checkValidDigit(digit: Digitos) {
        if (operador.isEmpty()) {
        if ((digit1.isEmpty() && digit.value != "0") || (digit1.isNotEmpty() && digit1.length < 3)) {
            digit1 += digit.value
        }
    } else {
        if ((digit2.isEmpty() && digit.value != "0") || (digit2.isNotEmpty() && digit2.length < 3)) {
            digit2 += digit.value
        }
    }
        setOP()
    }

    override fun checkOperator(value: Operadores) {
        if (digit1.isNotEmpty()) {
        operador = value.operator
            setOP()
        result()
    }
    }

    override fun clear() {
        digit1 = ""
        digit2 = ""
        setOP()
        callBackView.setResultados("")
    }

    override fun delete() {
        if (digit2.isNotEmpty()) {
            digit2 = digit2.dropLast(1)
        } else if (digit2.isEmpty() && operador.isNotEmpty()) {
            operador = ""
        } else {
            digit1 = digit1.dropLast(1)
        }
        setOP()
    }
   /* private fun removeLastNchars(str: String, n: Int): String {
        return if (str.length < n || str.isEmpty()) {
            str
        } else {
            str.substring(0, str.length - n)
        }
    }*/

    override fun autoResult(autoResult: Boolean) {
       this.autoResult=autoResult
        result()
    }

    override fun result() {
        if (digit2.isEmpty()){
            callBackView.setResultados("")
        }else{
            val num=digit1.toInt()
            val num2=digit2.toInt()
            val result=when(operador){
                Operadores.suma.operator -> {
                    suma(num, num2)
                }

                Operadores.resta.operator -> {
                    resta(num, num2)
                }

                Operadores.mult.operator -> {
                    multi(num, num2)
                }

                Operadores.div.operator -> {
                    div(num, num2)
                }
                else -> {
                    "--Error--"
                }

            }


            callBackView.setResultados("$result")
        }
    }
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