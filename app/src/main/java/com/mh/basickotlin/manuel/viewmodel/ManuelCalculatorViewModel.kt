package com.mh.basickotlin.manuel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mh.basickotlin.manuel.model.Digit
import com.mh.basickotlin.manuel.model.Operator
import com.mh.basickotlin.manuel.presenter.contract.ManuelCalculatorContract

class ManuelCalculatorViewModel : ViewModel(), ManuelCalculatorContract.Presenter {

    var textOperation = MutableLiveData<String>()
    var textResult = MutableLiveData<String>()

    private var digit1 = ""
    private var digit2 = ""
    private var operator = ""

    var flagAutoResult = false

    private fun setOperation() {
        textOperation.value = "$digit1 $operator $digit2"
        if (flagAutoResult) {
            result()
        }
    }

    override fun checkDigit(digit: Digit) {
        if (operator.isEmpty()) {
            if ((digit1.isEmpty() && digit.value != "0") || (digit1.isNotEmpty() && digit1.length < 3)) {
                digit1 += digit.value
            }
        } else {
            if ((digit2.isEmpty() && digit.value != "0") || (digit2.isNotEmpty() && digit2.length < 3)) {
                digit2 += digit.value
            }
        }
        setOperation()
    }

    override fun checkOperator(value: Operator) {
        if (digit1.isNotEmpty()) {
            operator = value.operator
            setOperation()
            result()
        }
    }

    override fun clear() {
        digit1 = ""
        digit2 = ""
        operator = ""

        setOperation()
        textResult.value = ""
    }

    override fun delete() {
        if (digit2.isNotEmpty()) {
            digit2 = digit2.dropLast(1)
        } else if (digit2.isEmpty() && operator.isNotEmpty()) {
            operator = ""
        } else {
            digit1 = digit1.dropLast(1)
        }
        setOperation()
    }

    override fun autoResult(autoResult: Boolean) {
        result()
    }

    override fun result() {
        if (digit2.isEmpty()) {
            textResult.value = ""
        } else {
            val d1 = digit1.toInt()
            val d2 = digit2.toInt()

            val result = when (operator) {
                Operator.ADD.operator -> {
                    add(d1, d2)
                }

                Operator.SUB.operator -> {
                    res(d1, d2)
                }

                Operator.MUL.operator -> {
                    mul(d1, d2)
                }

                Operator.DIV.operator -> {
                    div(d1, d2)
                }
                else -> {
                    "--Error--"
                }
            }

            textResult.value = result.toString()
        }
    }

    fun add(x: Int, y: Int): Int {
        return x.plus(y)
    }

    fun res(x: Int, y: Int): Int {
        return x.minus(y)
    }

    fun mul(x: Int, y: Int): Int {
        return x.times(y)
    }

    fun div(x: Int, y: Int): Int {
        return x.div(y)
    }
}
