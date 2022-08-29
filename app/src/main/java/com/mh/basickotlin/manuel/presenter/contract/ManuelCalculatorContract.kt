package com.mh.basickotlin.manuel.presenter.contract

import com.mh.basickotlin.manuel.model.Digit
import com.mh.basickotlin.manuel.model.Operator

interface ManuelCalculatorContract {

    interface View {
        fun setOperation(operation: String)
        fun setResult(result: String)
    }

    interface Presenter {
        fun checkDigit(digit: Digit)
        fun checkOperator(value: Operator)
        fun clear()
        fun delete()
        fun autoResult(autoResult: Boolean)
        fun result()
    }
}
