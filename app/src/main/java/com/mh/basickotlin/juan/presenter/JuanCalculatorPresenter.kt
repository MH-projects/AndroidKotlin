package com.mh.basickotlin.juan.presenter

import android.util.Log
import com.mh.basickotlin.juan.presenter.contract.JuanCalculatorContract

class JuanCalculatorPresenter(
    private val callbackView: JuanCalculatorContract.View
) : JuanCalculatorContract.Presenter {
    private var cant1 = ""
    private var cant2 = ""
    private var operation = ' '
    private var res = 0
    private var aux = ""

    override fun prueba() {
        callbackView.setResult(aux)
    }
    override fun retroceso() {
        var canaux1 = ""
        var resaux = ""
        if (cant2.isEmpty()) {
            resaux = "$cant1"
            if (operation == ' ') {
                if (!cant1.isEmpty()) {
                    canaux1 = cant1.dropLast(1)
                    cant1 = canaux1
                    resaux = "$cant1"
                }
            }
            operation = ' '
            res = 0
        } else {
            canaux1 = cant2.dropLast(1)
            cant2 = canaux1
            resaux = "$cant1$operation$cant2"
        }

        callbackView.setOperation("$resaux")
    }

    override fun getOperation() {
        val x = if (cant1.isEmpty()) 0 else cant1.toInt()
        val y = if (cant2.isEmpty()) 0 else cant2.toInt()
        if (operation != ' ') {
            res = when (operation) {
                '+' -> { suma(x, y) }
                '-' -> { resta(x, y) }
                'x' -> { mult(x, y) }
                else -> { div(x, y) }
            }
        }
        callbackView.setResult("$res")
    }

    override fun clearAll() {
        cant1 = ""
        cant2 = ""
        operation = ' '
        res = 0
        callbackView.setOperation("")
        callbackView.setResult("")
    }

    override fun validateDigit(caracter: Char) {
        if (operation == ' ') {
            if (cant1.length < 3) {
                cant1 += caracter
            } else {
            }
        } else {
            if (cant2.length < 3) {
                cant2 += caracter
            } else {
            }
        }
        callbackView.setOperation("$cant1")
        operation?.let { operadorLambda ->
            Log.i("CALCULADORA", "Operation: $cant1 $operadorLambda $cant2")
            callbackView.setOperation("$cant1$operadorLambda$cant2")
        }
    }

    override fun validateOperation(caracter: Char) {
        operation = caracter
        callbackView.setOperation("$cant1$operation")
    }
    fun suma(val1: Int, val2: Int): Int {
        return val1 + val2
    }
    fun resta(val1: Int, val2: Int): Int {
        return val1 - val2
    }
    fun mult(val1: Int, val2: Int): Int {
        return val1 * val2
    }
    fun div(val1: Int, val2: Int): Int {
        if (val2 == 0) {
            return 0
        }
        return val1 / val2
    }
}
