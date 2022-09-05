/*
 * TypeError.kt
 * Android Kotlin App"
 * Created by Pablo Amaya on 02/09/2022, 15:57:48
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.pablo.presentation.model

enum class TypeError(val error: String) {
    NAME("El campo nombre es obligatorio"),
    BIRTHDAY("El campo fecha de nacimiento es obligatorio"),
    PHONE_EMPTY("El campo telefono es obligatorio"),
    PHONE_SMALL("El telefono debe ser de 10 digitos")
}
