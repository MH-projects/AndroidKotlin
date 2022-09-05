/*
 * PabloPresentationPresenter.kt
 * Android Kotlin App"
 * Created by Pablo Amaya on 01/09/2022, 14:53:36
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.pablo.presentation.presenter

import android.content.Context
import com.mh.basickotlin.pablo.presentation.model.Constants.KEY_AGE_PABLO
import com.mh.basickotlin.pablo.presentation.model.Constants.KEY_BIRTHDAY_PABLO
import com.mh.basickotlin.pablo.presentation.model.Constants.KEY_GENDER_PABLO
import com.mh.basickotlin.pablo.presentation.model.Constants.KEY_NAME_PABLO
import com.mh.basickotlin.pablo.presentation.model.Constants.KEY_PHONE_PABLO
import com.mh.basickotlin.pablo.presentation.model.Constants.KEY_STATE_PABLO
import com.mh.basickotlin.pablo.presentation.model.Constants.KEY_SURNAME_PABLO
import com.mh.basickotlin.pablo.presentation.model.Constants.NAME_FILE
import com.mh.basickotlin.pablo.presentation.model.PresentationModel
import com.mh.basickotlin.pablo.presentation.model.TypeError
import com.mh.basickotlin.pablo.presentation.presenter.contract.PabloPresentationContract
import java.util.*

class PabloPresentationPresenter(
    context: Context,
    private val callBackView: PabloPresentationContract.View
) : PabloPresentationContract.Presenter {

    val sharedPref = context.getSharedPreferences(NAME_FILE, Context.MODE_PRIVATE)
    override fun saveData(presentation: PresentationModel) {
        when {
            presentation.name.isEmpty() || presentation.name.isBlank() -> callBackView.showError(
                TypeError.NAME
            )

            presentation.birthday.isEmpty() || presentation.birthday.isBlank() || presentation.birthday == "dd/mm/yyyy" -> callBackView.showError(
                TypeError.BIRTHDAY
            )

            presentation.phone.isEmpty() -> callBackView.showError(TypeError.PHONE_EMPTY)
            presentation.phone.length < 10 -> callBackView.showError(TypeError.PHONE_SMALL)

            else -> {
                val editor = sharedPref.edit()
                editor.putString(KEY_NAME_PABLO, presentation.name)
                editor.putString(KEY_SURNAME_PABLO, presentation.surName)
                editor.putString(KEY_BIRTHDAY_PABLO, presentation.birthday)
                editor.putString(KEY_AGE_PABLO, presentation.age)
                editor.putString(KEY_PHONE_PABLO, presentation.phone)
                editor.putString(KEY_STATE_PABLO, presentation.state)
                editor.putString(KEY_GENDER_PABLO, presentation.gender)
                editor.apply()
                callBackView.showSaveData("Datos guardados")
            }
        }
    }

    override fun getData() {
        callBackView.setSaveData(
            PresentationModel(
                sharedPref.getString(KEY_NAME_PABLO, "").toString(),
                sharedPref.getString(KEY_SURNAME_PABLO, "").toString(),
                sharedPref.getString(KEY_BIRTHDAY_PABLO, "").toString(),
                sharedPref.getString(KEY_AGE_PABLO, "").toString(),
                sharedPref.getString(KEY_PHONE_PABLO, "").toString(),
                sharedPref.getString(KEY_STATE_PABLO, "").toString(),
                sharedPref.getString(KEY_GENDER_PABLO, "").toString()
            )
        )
    }

    override fun getAge(birthday: String) {
        val currentDate = Calendar.getInstance()
        birthday.substring(6, birthday.length).toInt()
        var age = currentDate.get(Calendar.YEAR) - birthday.substring(6, birthday.length).toInt()
        val mes = currentDate.get(Calendar.MONTH) - birthday.substring(3, 5).toInt()
        val dia = currentDate.get(Calendar.DATE) - birthday.substring(0, 2).toInt()
        if (mes < 0 || mes == 0 && dia < 0) age--
        callBackView.showAge(age.toString())
    }
}
