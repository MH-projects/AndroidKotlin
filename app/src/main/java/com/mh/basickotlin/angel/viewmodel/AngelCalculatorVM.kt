package com.mh.basickotlin.angel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mh.basickotlin.angel.calculator.presenter.Operadores
import com.mh.basickotlin.angel.model.Numbers
import com.mh.basickotlin.angel.model.Operators

class AngelCalculatorVM : ViewModel() {
    private val _textOperation = MutableLiveData<String>()
    private val _textResult = MutableLiveData<String>()

    val textOperation: LiveData<String> get() = _textOperation
    val textResult: LiveData<String> get() = _textResult

    private var quanty1 = ""
    private var quanty2 = ""
    private var operator = ""
    private var autoResult = false
    private var Operadores = Operadores()

    fun setOperation() {
        _textOperation.postValue("$quanty1 $operator $quanty2")
        if (autoResult) {
            result()
        }
    }

    fun checkDigit(digit: Numbers) {
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

    fun checkOperator(value: Operators) {
        if (quanty1.isNotEmpty()) {
            operator = value.operator
            setOperation()
            result()
        }
    }

    fun clear() {
        quanty1 = ""
        quanty2 = ""
        operator = ""
        setOperation()
        _textResult.postValue("")
    }

    fun deletelast() {
        if (quanty2.isNotEmpty()) {
            quanty2 = quanty2.dropLast(1)
        } else if (quanty2.isEmpty() && operator.isNotEmpty()) {
            operator = ""
        } else {
            quanty1 = quanty1.dropLast(1)
        }
        putOperation()
    }

    fun putOperation() {
        _textOperation.postValue("$quanty1 $operator $quanty2")
        if (autoResult) {
            result()
        }
    }

    fun autoResult(autoResult: Boolean) {
        this.autoResult = autoResult
        result()
    }

    fun result() {
        if (quanty2.isEmpty()) {
            _textResult.postValue("")
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
            _textResult.postValue(result.toString())
        }
    }
}
