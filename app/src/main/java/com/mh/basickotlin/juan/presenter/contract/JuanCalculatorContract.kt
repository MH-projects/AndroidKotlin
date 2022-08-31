package com.mh.basickotlin.juan.presenter.contract

interface JuanCalculatorContract {

    interface View {
        fun setOperation(string: String)
        fun setResult(string: String)
    }
    interface Presenter {
        fun validateDigit(char: Char)
        fun prueba()
        fun validateOperation(caracter: Char)
        fun clearAll()
        fun retroceso()
        fun getOperation()
    }
}
