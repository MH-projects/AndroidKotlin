/*
 * JosueWelcomeContract.kt
 * Android Kotlin App
 * Created by Josue Isaias on 01/09/2022, 15:36:15
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.welcomejc.presenter.contract
import com.mh.basickotlin.josue.welcomejc.model.JosueWelcomeForm

interface JosueWelcomeContract {

    interface InterfaceWelcomeView {
        // MostrarAlerta de Succes
        fun mostrarInfo(message: String)
        fun mostrarResultado(res: Int)
        // fun mostrarresultadoenpantalla()
    }

    interface InterfaceWelcomePresenter {
        // Back o Logica del proyecto QUE QUIERES QUE HAGA DE TRAS USER
        fun guardarInfo(dataUsr: JosueWelcomeForm)
        fun deleteData()
        fun suma(n: Int, n2: Int)
        // fun resta(parametros)
    }
}
