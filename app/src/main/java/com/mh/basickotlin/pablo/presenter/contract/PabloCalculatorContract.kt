package com.mh.basickotlin.pablo.presenter.contract

import com.mh.basickotlin.pablo.model.BasicOperations
import com.mh.basickotlin.pablo.model.Number

interface PabloCalculatorContract {

    interface View {
        fun setOperation(operation: String)
        fun setResult(result: String)
        fun showToast(text: String)
    }

    interface Presenter {
        fun checkDigit(number: Number)
        fun checkOperator(value: BasicOperations)
        fun clear()
        fun delete()
        fun autoResult(autoResult: Boolean)
        fun result()
    }
}
