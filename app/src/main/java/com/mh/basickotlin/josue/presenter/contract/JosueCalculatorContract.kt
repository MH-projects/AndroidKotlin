package com.mh.basickotlin.josue.presenter.contract

import com.mh.basickotlin.josue.model.Digito
import com.mh.basickotlin.josue.model.Operator

interface JosueCalculatorContract {

    interface View {
        fun showOperation(operation: String)
        fun showResult(result: String)
    }
    interface MediatorModelAndView {
        // Aqui se establece toda la logica del proyecto
        fun checkNums(digitos: Digito)
        fun checkOper(operadores: Operator)
        fun clean()
        fun errase()
        fun resultAuto(autoResult: Boolean)
        fun resultado()
    }
}
