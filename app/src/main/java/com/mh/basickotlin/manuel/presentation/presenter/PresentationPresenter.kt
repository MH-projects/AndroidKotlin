/*
 * PresentationPresenter.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 01/09/2022, 13:05:59
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.presentation.presenter

import android.content.Context
import android.content.SharedPreferences
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_KEY_MH_AGE
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_KEY_MH_BIRTHDAY
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_KEY_MH_GENDER
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_KEY_MH_NAME
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_KEY_MH_PHONE
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_KEY_MH_STATE
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_KEY_MH_SURNAME
import com.mh.basickotlin.manuel.presentation.model.Constants.SP_MH_PRESENTATION
import com.mh.basickotlin.manuel.presentation.model.PresentationData
import java.util.*

class PresentationPresenter(
    ctx: Context,
    private val callBackView: PresentationContract.View
) : PresentationContract.Presenter {

    private var sp: SharedPreferences =
        ctx.getSharedPreferences(SP_MH_PRESENTATION, Context.MODE_PRIVATE)

    override fun getInfo() {
        callBackView.showInfo(
            PresentationData(
                name = sp.getString(SP_KEY_MH_NAME, "").toString(),
                surname = sp.getString(SP_KEY_MH_SURNAME, "").toString(),
                birthday = sp.getString(SP_KEY_MH_BIRTHDAY, "").toString(),
                age = sp.getInt(SP_KEY_MH_AGE, 0),
                phone = sp.getString(SP_KEY_MH_PHONE, "").toString(),
                state = sp.getString(SP_KEY_MH_STATE, "").toString(),
                gender = sp.getString(SP_KEY_MH_GENDER, "").toString()
            )
        )
    }

    override fun saveData(data: PresentationData) {
        when {
            data.name.isEmpty() -> callBackView.showErrorName()
            data.birthday == "dd/mm/yyyy" -> callBackView.showErrorBirthday()
            data.phone.isEmpty() -> callBackView.showErrorNumber("Número obligatorio")
            data.phone.length < 10 -> callBackView.showErrorNumber("Número no vàlido")
            else -> {
                val editor = sp.edit()
                editor.putString(SP_KEY_MH_NAME, data.name)
                editor.putString(SP_KEY_MH_SURNAME, data.surname)
                editor.putString(SP_KEY_MH_PHONE, data.phone)
                editor.putString(SP_KEY_MH_BIRTHDAY, data.birthday)
                editor.putInt(SP_KEY_MH_AGE, data.age)
                editor.putString(SP_KEY_MH_STATE, data.state)
                editor.putString(SP_KEY_MH_GENDER, data.gender)

                editor.apply()

                callBackView.showResult("Información guardada")
            }
        }
    }

    override fun calculateAge(birthday: String) {
        // dd/mm/yyyy
        val day = birthday.substring(0, 2).toInt()
        val month = birthday.substring(3, 5).toInt()
        val year = birthday.substring(6, 10).toInt()

        val c = Calendar.getInstance()

        var age = c.get(Calendar.YEAR) - year

        /*
        Si el mes actual es mayor al mes de su cumpleaños aun no cumple años
        y se tiene que restar uno a su edad
         */
        if ((c.get(Calendar.MONTH) - 1) > month) {
            age--
        }
        /*
        Si estamos en el mismo mes verificamos si el dia actual es mayor a su fecha de nacimiento
        aun no cumple años y se tiene que restar uno a su edad
         */
        else if ((c.get(Calendar.MONTH) - 1) == month && c.get(Calendar.DAY_OF_MONTH) > day) {
            age--
        }

        callBackView.showAge(age)
    }
}
