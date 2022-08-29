package com.mh.basickotlin.antonio.presenter

import com.mh.basickotlin.antonio.model.Digitos
import com.mh.basickotlin.antonio.model.Operadores
import com.mh.basickotlin.ui.manuel.model.Operator

interface AntonioCalculadorContract {

    interface view{
        fun setOP(op: String)
        fun setResultados(result: String)
    }

    interface presenter{
        fun checkValidDigit(digito: Digitos)
        fun checkOperator(value: Operadores)
        fun clear()
        fun delete()
        fun autoResult(autoResult: Boolean)
        fun result()
    }

}