/*
 * DataPiker.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 01/09/2022, 16:07:56
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.presentation.presenter

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import java.util.*

class DataPikerAlert(private val ctx:Context) {

    private var listener: DatePickerDialog.OnDateSetListener? = null
    fun show(editText: EditText){
        val c=Calendar.getInstance()
        val y=c.get(Calendar.YEAR)  //para restar estos años
        val m=c.get(Calendar.MONTH)
        val d=c.get(Calendar.DAY_OF_MONTH)
        //contexto
        //listener
        //year
        //month
        //day
        val datapiker= DatePickerDialog(ctx,
            {DatePicker,y,m,d ->
                editText.setText("$d-${m+1}-$y")
            },
            y,
            m,
            d)
        //restriccion de edad
        //en y ponemos el año maximo o minimo que deseemos mostrar
        c.set(Calendar.YEAR,y)
        datapiker.datePicker.maxDate=c.timeInMillis
        c.set(Calendar.YEAR,1950)
        datapiker.datePicker.minDate=c.timeInMillis
        datapiker.show()
    }



}