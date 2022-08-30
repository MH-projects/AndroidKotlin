package com.mh.basickotlin.pablo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mh.basickotlin.pablo.model.BasicOperations
import com.mh.basickotlin.pablo.model.Messages
import com.mh.basickotlin.pablo.model.Number

class PabloCalculatorViewModel : ViewModel() {
    private val _textOperation = MutableLiveData<String>()
    private val _textResult = MutableLiveData<String>()
    private val _textToast = MutableLiveData<String>()
    private val _autoResultCheck = MutableLiveData<Boolean>()

    val textOperation: LiveData<String> get() = _textOperation
    val textResult: LiveData<String> get() = _textResult
    val textToast: LiveData<String> get() = _textToast
    val autoResultCheck: LiveData<Boolean> get() = _autoResultCheck

    private var numberOne = ""
    private var numberTwo = ""
    private var specialCharacter = ""

    fun checkDigit(number: Number) {
        if (specialCharacter.isEmpty()) {
            if ((numberOne.isEmpty() && number.value != "0") || (numberOne.isNotEmpty() && numberOne.length < 3)) {
                numberOne += number.value
            } else showToast(Messages.NUMBER.messages)
        } else if ((numberTwo.isEmpty() && number.value != "0") || (numberTwo.isNotEmpty() && numberTwo.length < 3)) {
            numberTwo += number.value
        } else showToast(Messages.NUMBER.messages)
        setOperation()
    }

    fun checkOperator(value: BasicOperations) {
        if (numberOne.isEmpty()) showToast(Messages.OPERATOR.messages)
        else {
            specialCharacter = value.operator
        }
        setOperation()
        result()
    }

    fun clear() {
        numberOne = ""
        numberTwo = ""
        specialCharacter = ""
        setOperation()
        result()
    }

    fun delete() {
        if (numberOne.isNotEmpty() && specialCharacter.isEmpty() && numberTwo.isEmpty()) {
            numberOne = numberOne.dropLast(1)
        } else if (numberOne.isNotEmpty() && specialCharacter.isNotEmpty() && numberTwo.isEmpty()) {
            specialCharacter = ""
        } else {
            numberTwo = numberTwo.dropLast(1)
        }
        setOperation()
    }

    fun autoResult(autoResult: Boolean) {
        _autoResultCheck.postValue(autoResult)
        result()
    }

    fun result() {
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
            _textResult.postValue(result.toString())
        } else if (_autoResultCheck.value == true) _textResult.postValue("$numberOne")
        else _textResult.postValue("")
    }

    private fun setOperation() {
        _textOperation.postValue("$numberOne$specialCharacter$numberTwo")
        if (_autoResultCheck.value == true) result()
    }

    private fun showToast(text: String) {
        _textToast.postValue(text)
    }

    private fun convertStringToInt(number: String): Int {
        return if (number.isEmpty()) 0 else number.toInt()
    }

    fun plus(x: Int, y: Int): Int = x.plus(y)
    fun minus(x: Int, y: Int): Int = x.minus(y)
    fun times(x: Int, y: Int): Int = x.times(y)
    fun div(x: Int, y: Int): Int = x.div(y)
}
