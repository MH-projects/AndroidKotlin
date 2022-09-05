/*
 * PresentationModel.kt
 * Android Kotlin App"
 * Created by Pablo Amaya on 01/09/2022, 14:48:33
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.pablo.presentation.model

data class PresentationModel(
    var name: String,
    var surName: String = "",
    var birthday: String,
    var age: String,
    var phone: String,
    var state: String = "",
    var gender: String = ""
)
