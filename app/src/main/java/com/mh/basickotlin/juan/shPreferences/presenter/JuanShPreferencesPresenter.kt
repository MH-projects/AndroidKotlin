/*
 * JuanShPreferencesPresenter.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 01/09/2022, 15:13:59
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.shPreferences.presenter

import com.mh.basickotlin.juan.shPreferences.model.Formulario
import com.mh.basickotlin.juan.shPreferences.model.ShPref
import com.mh.basickotlin.juan.shPreferences.presenter.contract.JuanShPreferenceContract

class JuanShPreferencesPresenter(
    private val callbackView: JuanShPreferenceContract.View,
    private val shpref: ShPref
) : JuanShPreferenceContract.Presenter {

    override fun setAge(d: Int, m: Int, y: Int) {
        var age = 2022 - y
        callbackView.birthday("$d/$m/$y")
        callbackView.showAge(age)
    }

    override fun SaveData(data: Formulario) {
        shpref.setInfo(data)
    }

    override fun restaurar() {
        shpref.getName()?.let { callbackView.setName(it) }
        shpref.getSurname()?.let { callbackView.setSurname(it) }
        callbackView.setAge(shpref.getAge())
        callbackView.setPhone(shpref.getNumber())
        shpref.getCity()?.let { callbackView.setCity(it) }
        shpref.getGenre()?.let { callbackView.setGenre(it) }
        shpref.getDate()?.let { callbackView.setBirthday(it) }
    }
}
