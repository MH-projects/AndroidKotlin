/*
 * DatePickerAlert.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 01/09/2022, 16:08:09
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.shPreferences.presenter

import android.app.DatePickerDialog
import android.content.Context
import com.mh.basickotlin.juan.shPreferences.presenter.contract.JuanShPreferenceContract
import java.util.*

class DatePickerAlert(private val ctx: Context, val presenter: JuanShPreferenceContract.Presenter) {
    private var year1 = ""
    private var month1 = ""
    private var day1 = ""
    fun show() {
        val calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR) - 18
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePicker = DatePickerDialog(
            ctx,
            { datePicker, y, m, d ->
                year1 = y.toString()
                month1 = m.toString()
                day1 = d.toString()
                println("Date: $d - $m - $y")
                presenter.setAge(d, m, y)
            },
            year,
            month,
            day
        )
        calendar.set(Calendar.YEAR, year)
        datePicker.datePicker.maxDate = calendar.timeInMillis

        calendar.set(Calendar.YEAR, 1950)
        datePicker.datePicker.minDate = calendar.timeInMillis

        datePicker.show()
    }

}
