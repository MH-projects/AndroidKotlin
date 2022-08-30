package com.mh.basickotlin.ui.angel.presenter

import com.mh.basickotlin.ui.angel.model.Numbers
import com.mh.basickotlin.ui.angel.model.Operators

interface AngelCalcContract {
    interface View {
        fun putOperation(operation: String)
        fun putResult(result: String)
    }

    interface presenter {
        fun checkDigit(digit: Numbers)
        fun checkOperator(value: Operators)
        fun clear()
        fun deletelast()
        fun autoResult(autoResult: Boolean)
        fun result()
    }
}
