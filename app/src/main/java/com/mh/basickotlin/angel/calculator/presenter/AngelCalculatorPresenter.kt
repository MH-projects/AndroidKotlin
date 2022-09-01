/*
 * AngelCalculatorPresenter.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 11:19:17
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */
package com.mh.basickotlin.angel.calculator.presenter

import com.mh.basickotlin.angel.calculator.model.Numbers
import com.mh.basickotlin.angel.calculator.model.Operators
import com.mh.basickotlin.angel.presenter.AngelCalcContract

class AngelCalculatorPresenter(
    private val callBackView: AngelCalcContract.View
) : AngelCalcContract.presenter {

    private var quanty1 = ""
    private var quanty2 = ""
    private var operator = ""
    private var autoResult = false
    lateinit var Operadores: Operadores

    private fun setOperation() {
        callBackView.putOperation("$quanty1 $operator $quanty2")
        if (autoResult) {
            result()
        }
    }

    override fun checkDigit(digit: Numbers) {
        if (operator.isEmpty()) {
            if ((quanty1.isEmpty() && digit.valor != "0") || (quanty1.isNotEmpty() && quanty1.length < 3)) {
                quanty1 += digit.valor
            }
        } else {
            if ((quanty2.isEmpty() && digit.valor != "0") || (quanty2.isNotEmpty() && quanty2.length < 3)) {
                quanty2 += digit.valor
            }
        }
        setOperation()
    }

    override fun checkOperator(value: Operators) {
        if (quanty1.isNotEmpty()) {
            operator = value.operator
            setOperation()
            result()
        }
    }

    override fun clear() {
        quanty1 = ""
        quanty2 = ""
        operator = ""
        setOperation()
        callBackView.putResult("")
    }

    override fun deletelast() {
        if (quanty2.isNotEmpty()) {
            quanty2 = quanty2.dropLast(1)
        } else if (quanty2.isEmpty() && operator.isNotEmpty()) {
            operator = ""
        } else {
            quanty1 = quanty1.dropLast(1)
        }
        putOperation()
    }

    private fun putOperation() {
        callBackView.putOperation("$quanty1 $operator $quanty2")
        if (autoResult) {
            result()
        }
    }

    override fun autoResult(autoResult: Boolean) {
        this.autoResult = autoResult
        result()
    }

    override fun result() {
        if (quanty2.isEmpty()) {
            callBackView.putResult("")
        } else {
            val a = quanty1.toInt()
            val b = quanty2.toInt()

            val result = when (operator) {
                Operators.Plus.operator -> {
                    Operadores.plus(a, b)
                }

                Operators.Less.operator -> {
                    Operadores.less(a, b)
                }

                Operators.By.operator -> {
                    Operadores.by(a, b)
                }

                Operators.Div.operator -> {
                    Operadores.split(a, b)
                }
                else -> {
                    "--Error--"
                }
            }
            callBackView.putResult("$result")
        }
    }
}
