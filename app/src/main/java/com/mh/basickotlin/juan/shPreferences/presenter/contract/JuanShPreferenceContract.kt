/*
 * JuanShPreferenceContract.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 01/09/2022, 15:24:49
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.shPreferences.presenter.contract

import com.mh.basickotlin.juan.shPreferences.model.Formulario

interface JuanShPreferenceContract {
    interface View {
        fun showAge(age: Int)
        fun birthday(res: String)
        fun Resultado(res: String)
        fun ShowResult()
        fun setBirthday(name: String)
        fun setName(name: String)
        fun setSurname(name: String)
        fun setAge(name: Int)
        fun setPhone(name: Int)
        fun setCity(name: String)
        fun setGenre(name: String)
    }
    interface Presenter {
        fun setAge(d: Int, m: Int, y: Int)
        fun SaveData(data: Formulario)
        fun restaurar()
    }
}
