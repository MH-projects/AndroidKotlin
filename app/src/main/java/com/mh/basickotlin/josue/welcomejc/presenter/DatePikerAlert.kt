/*
 * DatePikerAlert.kt
 * Android Kotlin App
 * Created by Josue Isaias on 01/09/2022, 16:08:25
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.welcomejc.presenter

import android.app.DatePickerDialog
import android.content.Context
import java.util.*

class DatePikerAlert(private val context: Context) {
    fun show() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val datePikerAlert = DatePickerDialog(
            context,
            { dateP, y, m, d ->
                println("Date $d - $m - $y")
            },
            year,
            month,
            day
        )
        datePikerAlert.show()
    }
}
