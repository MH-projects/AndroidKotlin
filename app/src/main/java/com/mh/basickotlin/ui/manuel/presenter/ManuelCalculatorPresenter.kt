package com.mh.basickotlin.ui.manuel.presenter

import com.mh.basickotlin.ui.manuel.model.Digit
import com.mh.basickotlin.ui.manuel.model.Operator
import com.mh.basickotlin.ui.manuel.presenter.contract.ManuelCalculatorContract

class ManuelCalculatorPresenter(
    private val callBackView: ManuelCalculatorContract.View
) : ManuelCalculatorContract.Presenter {

    private var digit1 = ""
    private var digit2 = ""
    private var operator = ""

    private var autoResult = false

    private fun setOperation() {
        callBackView.setOperation("$digit1 $operator $digit2")
        if (autoResult) {
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
        callBackView.setResult("")
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
        this.autoResult = autoResult
        result()
    }

    override fun result() {
        if (digit2.isEmpty()) {
            callBackView.setResult("")
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

            callBackView.setResult("$result")
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
