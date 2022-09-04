/*
 * ShPref.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 02/09/2022, 16:05:36
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.shPreferences.model

import android.content.Context

class ShPref(context: Context) {
    val SharedPreferences = context.getSharedPreferences("df", Context.MODE_PRIVATE)
    val editor = SharedPreferences.edit()

    fun setInfo(data: Formulario) {
        editor.putString("name", data.name)
        editor.putString("surname", data.surname)
        editor.putString("date", data.date)
        editor.putInt("age", data.age)
        editor.putInt("phone", data.phone)
        editor.putString("city", data.city)
        editor.putString("genre", data.genre)
        editor.apply()
        editor.commit()
    }
    fun getName(): String? {
        return SharedPreferences.getString("name", "")
    }
    fun getSurname(): String? {
        return SharedPreferences.getString("surname", "")
    }
    fun getDate(): String? {
        return SharedPreferences.getString("date", "")
    }

    fun getAge(): Int {
        return SharedPreferences.getInt("age", 0)
    }
    fun getNumber(): Int {
        return SharedPreferences.getInt("phone", 0)
    }
    fun getCity(): String? {
        return SharedPreferences.getString("city", "")
    }
    fun getGenre(): String? {
        return SharedPreferences.getString("genre", "")
    }
}
