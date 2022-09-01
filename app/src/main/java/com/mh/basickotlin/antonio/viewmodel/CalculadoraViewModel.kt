package com.mh.basickotlin.antonio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mh.basickotlin.antonio.model.Digitos
import com.mh.basickotlin.antonio.model.Operadores

class CalculadoraViewModel: ViewModel() {
    private val operacion = MutableLiveData<String>()
    private val Resultado = MutableLiveData<String>()

    val textOperacion: LiveData<String> get() = operacion
    val textResultado: LiveData<String> get() = Resultado

    private var num = ""
    private var num2 = ""
    private var operador = ""

    private var AutoResult = false


    private fun setOP() {
        operacion.postValue("$num $operador $num2")
        if (AutoResult) {
            result()
        }
    }

     fun checkValidDigit(digit: Digitos) {
        if (operador.isEmpty()) {
            if ((num.isEmpty() && digit.value != "0") || (num.isNotEmpty() && num.length < 3)) {
                num += digit.value
            }
        } else {
            if ((num2.isEmpty() && digit.value != "0") || (num2.isNotEmpty() && num2.length < 3)) {
                num2 += digit.value
            }
        }
        setOP()
    }

     fun checkOperator(value: Operadores) {
        if (num.isNotEmpty()) {
            operador = value.operator
            setOP()
            result()
        }
    }

     fun clear() {
        num = ""
        num2 = ""
        setOP()
        Resultado.postValue("")
    }

     fun delete() {
        if (num2.isNotEmpty()) {
            num2 = num2.dropLast(1)
        } else if (num2.isEmpty() && operador.isNotEmpty()) {
            operador = ""
        } else {
            num = num.dropLast(1)
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

     fun autoResult(autoResult: Boolean) {
            this.AutoResult=autoResult
        result()
    }

     fun result() {
        if (num2.isEmpty()){
            Resultado.postValue("")
        }else{
            val num=num.toInt()
            val num2=num2.toInt()
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
                    com.mh.basickotlin.antonio.presenter.div(num, num2)
                }
                else -> {
                    "--Error--"
                }

            }


            Resultado.postValue("$result")
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