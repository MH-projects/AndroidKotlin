package com.mh.basickotlin.pablo.presenter

import com.mh.basickotlin.pablo.model.BasicOperations
import com.mh.basickotlin.pablo.model.Messages
import com.mh.basickotlin.pablo.model.Number
import com.mh.basickotlin.pablo.presenter.contract.PabloCalculatorContract

class PabloCalculatorPresenter(
    private val callBackView: PabloCalculatorContract.View
) : PabloCalculatorContract.Presenter {
    private var autoResult = false
    private var numberOne = ""
    private var numberTwo = ""
    private var specialCharacter = ""

    override fun checkDigit(number: Number) {
        if (specialCharacter.isEmpty()) {
            if ((numberOne.isEmpty() && number.value != "0") || (numberOne.isNotEmpty() && numberOne.length < 3)) {
                numberOne += number.value
            } else showToast(Messages.NUMBER.messages)
        } else if ((numberTwo.isEmpty() && number.value != "0") || (numberTwo.isNotEmpty() && numberTwo.length < 3)) {
            numberTwo += number.value
        } else showToast(Messages.NUMBER.messages)
        setOperation()
    }

    override fun checkOperator(value: BasicOperations) {
        if (numberOne.isEmpty()) showToast(Messages.OPERATOR.messages)
        else {
            specialCharacter = value.operator
        }
        setOperation()
        result()
    }

    override fun clear() {
        numberOne = ""
        numberTwo = ""
        specialCharacter = ""
        setOperation()
        result()
    }

    override fun delete() {
        if (numberOne.isNotEmpty() && specialCharacter.isEmpty() && numberTwo.isEmpty()) {
            numberOne = numberOne.dropLast(1)
        } else if (numberOne.isNotEmpty() && specialCharacter.isNotEmpty() && numberTwo.isEmpty()) {
            specialCharacter = ""
        } else {
            numberTwo = numberTwo.dropLast(1)
        }
        setOperation()
    }

    override fun autoResult(autoResult: Boolean) {
        this.autoResult = autoResult
        result()
    }

    override fun result() {
        if (numberTwo.isNotEmpty()) {
            val x = convertStringToInt(numberOne)
            val y = convertStringToInt(numberTwo)
            val result = when (specialCharacter) {
                BasicOperations.ADD.operator -> {
                    plus(x, y)
                }
                BasicOperations.SUB.operator -> {
                    minus(x, y)
                }
                BasicOperations.MUL.operator -> {
                    times(x, y)
                }
                BasicOperations.DIV.operator -> {
                    div(x, y)
                }
                else -> {
                    "--Error--"
                }
            }
            callBackView.setResult("$result")
        } else if (autoResult) callBackView.setResult("$numberOne")
        else callBackView.setResult("")
    }

    private fun setOperation() {
        callBackView.setOperation("$numberOne$specialCharacter$numberTwo")
        if (autoResult) result()
    }

    private fun showToast(text: String) {
        callBackView.showToast(text)
    }

    fun convertStringToInt(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun plus(x: Int, y: Int): Int = x.plus(y)
    fun minus(x: Int, y: Int): Int = x.minus(y)
    fun times(x: Int, y: Int): Int = x.times(y)
    fun div(x: Int, y: Int): Int = x.div(y)
}
