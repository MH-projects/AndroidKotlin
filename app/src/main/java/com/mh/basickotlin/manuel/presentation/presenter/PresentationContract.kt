/*
 * PresentationContract.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 01/09/2022, 13:02:54
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.presentation.presenter

import com.mh.basickotlin.manuel.presentation.model.PresentationData

interface PresentationContract {

    interface View {

        // Errors
        fun showErrorName()
        fun showErrorBirthday()
        fun showErrorNumber(error: String)

        // Info
        fun showInfo(data: PresentationData)
        fun showBirthday(birthday: String)
        fun showAge(age: Int)
        fun showResult(status: String)
    }

    interface Presenter {
        fun getInfo()
        fun saveData(data: PresentationData)
        fun calculateAge(birthday: String)
    }
}
