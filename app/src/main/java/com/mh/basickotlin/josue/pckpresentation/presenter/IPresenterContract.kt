/*
 * IPresenterContract.kt
 * Android Kotlin App
 * Created by Josue Isaias on 02/09/2022, 17:05:32
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.pckpresentation.presenter

import com.mh.basickotlin.josue.pckpresentation.model.UsrDataForm

interface IPresenterContract {

    interface View {
        // Esto es lo que se mostrara en la view
        fun showAlert()
    }

    interface Presenter {
        // Logica
        fun saveDataUsr(infoUsr: UsrDataForm)
    }
}
