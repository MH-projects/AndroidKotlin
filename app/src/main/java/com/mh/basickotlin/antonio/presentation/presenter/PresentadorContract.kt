/*
 * PresentadorContract.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 01/09/2022, 15:12:23
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.presentation.presenter

import com.mh.basickotlin.antonio.presentation.model.dataPresenter

interface PresentadorContract {
    interface View{
        fun showData()
        fun setData()
        fun loadData(datos: dataPresenter)
        fun error()
        fun showResult(status:String)
        fun showAge(birthday:String)
    }

    interface presenter{
        fun getData()
        fun setAge(birdthday:String):String
        fun saveData(datos: dataPresenter)
    }
}