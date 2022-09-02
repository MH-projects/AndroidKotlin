/*
 * AngelFormContract.kt
 * Android Kotlin App
 * Created by Angel Morales on 01/09/2022, 14:49:41
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.info.presenter

import com.mh.basickotlin.angel.info.model.AngelFormModel

interface AngelFormContract {
    interface View {
        fun showData(data: String)
        fun loadData(data: AngelFormModel)
    }

    interface presenter {
        fun saveData(data: AngelFormModel)
        fun returnData()
        fun showError()
    }
}
