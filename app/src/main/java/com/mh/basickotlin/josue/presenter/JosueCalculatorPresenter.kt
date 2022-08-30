package com.mh.basickotlin.josue.presenter

import com.mh.basickotlin.josue.model.Digito
import com.mh.basickotlin.josue.model.Operator
import com.mh.basickotlin.josue.presenter.contract.JosueCalculatorContract

class JosueCalculatorPresenter(
    private val callBackView: JosueCalculatorContract.View
) : JosueCalculatorContract.MediatorModelAndView {

    private var oneNumber = ""
    private var twoNumber = ""
    private var operator = ""
    private var autoR = false

    private fun muestraOperacion() {
        callBackView.showOperation("$oneNumber $operator $twoNumber")
        if (autoR) {
            resultado()
        }
    }

    override fun checkNums(digitos: Digito) {
        if (operator.isEmpty()) {
            if ((oneNumber.isEmpty() && digitos.value != "0") || (oneNumber.isNotEmpty() && oneNumber.length < 3)) {
                oneNumber += digitos.value
            }
        } else {
            if ((twoNumber.isEmpty() && digitos.value != "0") || (twoNumber.isNotEmpty() && twoNumber.length < 3)) {
                twoNumber += digitos.value
            }
        }
        muestraOperacion()
    }

    override fun checkOper(operadores: Operator) {
        if (oneNumber.isNotEmpty()) {
            operator = operadores.ope
            muestraOperacion()
            resultado()
        }
    }

    override fun clean() {
        operator = ""
        oneNumber = ""
        twoNumber = ""
        muestraOperacion()
        callBackView.showResult("")
    }

    override fun errase() {
        if (twoNumber.isNotEmpty()) {
            twoNumber = twoNumber.dropLast(1)
        } else if (twoNumber.isEmpty() && operator.isNotEmpty()) {
            operator = ""
        } else {
            oneNumber = oneNumber.dropLast(1)
        }
        muestraOperacion()
    }

    override fun resultAuto(autoResult: Boolean) {
        this.autoR = autoResult
        resultado()
    }

    override fun resultado() {
        if (twoNumber.isEmpty()) {
            callBackView.showResult("")
        } else {
            val n1 = oneNumber.toInt()
            val n2 = twoNumber.toInt()
            val resu = when (operator) {
                Operator.SUM.ope -> {
                    sumar(n1, n2)
                }
                Operator.REST.ope -> {
                    restar(n1, n2)
                }
                Operator.MULT.ope -> {
                    mult(n1, n2)
                }
                Operator.DIV.ope -> {
                    div(n1, n2)
                }
                else -> {
                    "--Error--"
                }
            }
            callBackView.showResult("$resu")
        }
    }

    fun sumar(primerNum: Int, segundNum: Int): Int {
        return primerNum.plus(segundNum)
    }
    fun restar(primerNum: Int, segundNum: Int): Int {
        return primerNum.minus(segundNum)
    }
    fun mult(primerNum: Int, segundNum: Int): Int {
        return primerNum.times(segundNum)
    }
    fun div(primerNum: Int, segundNum: Int): Int {
        return primerNum.div(segundNum)
    }
}
