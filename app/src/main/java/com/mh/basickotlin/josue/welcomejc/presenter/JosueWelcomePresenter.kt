/*
 * JosueWelcomePresenter.kt
 * Android Kotlin App
 * Created by Josue Isaias on 01/09/2022, 15:39:10
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.welcomejc.presenter
import com.mh.basickotlin.josue.welcomejc.model.JosueWelcomeForm
import com.mh.basickotlin.josue.welcomejc.presenter.contract.JosueWelcomeContract

class JosueWelcomePresenter(
    private val viewWelcomePresenter: JosueWelcomeContract.InterfaceWelcomeView
) : JosueWelcomeContract.InterfaceWelcomePresenter {

    override fun guardarInfo(dataUsr: JosueWelcomeForm) {
        viewWelcomePresenter.mostrarInfo("Esto es lo que ve el Usuario de regreso")
    }

    override fun deleteData() {
        viewWelcomePresenter.mostrarInfo("Se elimino la data")
    }

    override fun suma(n: Int, n2: Int) {
        var resul = n + n2
        viewWelcomePresenter.mostrarResultado(resul)
    }

    /*fun resta(
        resultado
        toda las operaciones
        mostrar resultado
        callback.mostarresultadoenpantalla=="2-2 = 0"

    )*/
}
