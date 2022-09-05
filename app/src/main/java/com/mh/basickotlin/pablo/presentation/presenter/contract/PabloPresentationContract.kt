/*
 * PabloInformationContract.kt
 * Android Kotlin App"
 * Created by Pablo Amaya on 01/09/2022, 14:50:40
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.pablo.presentation.presenter.contract

import com.mh.basickotlin.pablo.presentation.model.PresentationModel
import com.mh.basickotlin.pablo.presentation.model.TypeError

interface PabloPresentationContract {

    interface View {
        fun showError(typeError: TypeError)
        fun showSaveData(message: String)
        fun setSaveData(presentation: PresentationModel)
        fun showBirthday(birthday: String)
        fun showAge(age: String)
    }

    interface Presenter {
        fun saveData(presentation: PresentationModel)
        fun getData()
        fun getAge(birthday: String)
    }
}
