/*
 * AngelCalcContract.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 11:19:17
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.calculator.presenter

import com.mh.basickotlin.angel.calculator.model.Numbers
import com.mh.basickotlin.angel.calculator.model.Operators

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
