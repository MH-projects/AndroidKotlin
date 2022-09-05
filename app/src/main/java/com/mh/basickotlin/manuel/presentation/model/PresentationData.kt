/*
 * PresentationData.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 01/09/2022, 13:07:29
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.presentation.model

data class PresentationData(
    val name: String,
    val surname: String = "",
    val birthday: String,
    val age: Int,
    val phone: String,
    val state: String = "",
    val gender: String = ""
)
