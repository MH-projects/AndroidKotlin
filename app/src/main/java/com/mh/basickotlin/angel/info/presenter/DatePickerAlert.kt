/*
 * DAtePickerAlert.kt
 * Android Kotlin App
 * Created by Angel Morales on 01/09/2022, 16:13:40
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.info.presenter

import android.app.DatePickerDialog
import android.content.Context
import java.util.*

class DatePickerAlert(private val ctx: Context) {
    fun show() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR) - 18
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            ctx,
            { datePicket, y, m, d ->
                print("Date:  $d - $m - $d")
            },
            year,
            month,
            day
        )
        calendar.set(Calendar.YEAR, year)
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        calendar.set(Calendar.YEAR, 1950)
        datePickerDialog.datePicker.minDate = calendar.timeInMillis
        datePickerDialog.show()
    }
}
