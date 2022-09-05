/*
 * AntonioPresentationPresenter.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 01/09/2022, 15:15:07
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.presentation.presenter

import android.content.Context
import com.mh.basickotlin.antonio.presentation.model.DatosConstans.KEY_NAME
import com.mh.basickotlin.antonio.presentation.model.DatosConstans.KEY_NUMBER
import com.mh.basickotlin.antonio.presentation.model.DatosConstans.KEY_SURNAME
import com.mh.basickotlin.antonio.presentation.model.DatosConstans.NAME_FILE
import com.mh.basickotlin.antonio.presentation.model.dataPresenter
import java.util.*

class AntonioPresentationPresenter(
    private val callback: PresentadorContract.View,
    private val contx: Context
) : PresentadorContract.presenter {
    //SP inicializamos con el nombre del archivo y el modo de apertura
    private var sp = contx.getSharedPreferences(NAME_FILE, Context.MODE_PRIVATE)
    override fun getData() {
        callback.loadData(
            dataPresenter(
                sp.getString(KEY_NAME, "").toString(),
                sp.getString(KEY_SURNAME, "").toString(),
                sp.getString(KEY_NUMBER, "").toString()
            )
        )
    }

    override fun setAge(birthday:String): String {
        //dd/mm/yyyy
        val y=birthday.substring(0,2).toInt()
        val m=birthday.substring(2,4).toInt()
        val d=birthday.substring(4,8).toInt()
        var c=Calendar.getInstance()
        var valor:Int =c.get(Calendar.YEAR) - y
        return valor.toString()

    }

    override fun saveData(datos: dataPresenter) {
        if (datos.name.isNotEmpty()) {
            val edit = sp.edit()
            edit.putString(KEY_NAME, datos.name)
            edit.putString(KEY_SURNAME, datos.surname)
            edit.putString(KEY_NUMBER, datos.phone)
            edit.apply()
            callback.showData()
        }
    }

}