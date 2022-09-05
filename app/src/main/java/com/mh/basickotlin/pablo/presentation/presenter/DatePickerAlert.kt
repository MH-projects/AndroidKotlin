/*
 * DatePickerAlert.kt
 * Android Kotlin App"
 * Created by Pablo Amaya on 01/09/2022, 16:07:57
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.pablo.presentation.presenter

import android.app.DatePickerDialog
import android.content.Context
import com.mh.basickotlin.pablo.presentation.presenter.contract.PabloPresentationContract
import java.util.*

class DatePickerAlert(
    private val context: Context,
    private val callBackView: PabloPresentationContract.View
) {
    fun show() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR) - 18
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            context,
            { _, y, m, d ->
                callBackView.showBirthday(String.format("%02d/%02d/%d", d, m, y))
            },
            year,
            month,
            day
        )
        calendar.set(Calendar.YEAR, year)
        datePicker.datePicker.maxDate = calendar.timeInMillis
        calendar.set(Calendar.YEAR, 1950) // trae el año que tu queiras
        datePicker.datePicker.minDate = calendar.timeInMillis
        datePicker.show()
    }

    private fun getAge(year: Int, month: Int, day: Int) {
        val currentDate = Calendar.getInstance()
        var age = currentDate.get(Calendar.YEAR) - year
        val mes = currentDate.get(Calendar.MONTH) - month
        val dia = currentDate.get(Calendar.DATE) - day
        if (mes < 0 || mes == 0 && dia < 0) age--
        // callBackView.showAge(age)
    }
}
