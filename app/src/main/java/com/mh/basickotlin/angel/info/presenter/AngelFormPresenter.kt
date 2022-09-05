/*
 * AngelFormPresenter.kt
 * Android Kotlin App
 * Created by Angel Morales on 01/09/2022, 14:57:05
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.info.presenter

import android.content.Context
import com.mh.basickotlin.angel.info.model.AngelFormModel
import com.mh.basickotlin.angel.info.model.ObjectConstants.KEY_NAME
import com.mh.basickotlin.angel.info.model.ObjectConstants.KEY_PHONE
import com.mh.basickotlin.angel.info.model.ObjectConstants.KEY_SURNAME
import com.mh.basickotlin.angel.info.model.ObjectConstants.NAME_ANGEL

// Se pasa un contexto ya que lo requiere el sharedpreferences, y el callback esto para que se comunique con la vista
class AngelFormPresenter(context: Context, var callback: AngelFormContract.View) :
    AngelFormContract.presenter {
    // Se inicia el shared preference, pero con las constantes las cuales son las keys de object constants
    val sharedPreferences = context.getSharedPreferences(NAME_ANGEL, Context.MODE_PRIVATE)

    // Esta funcion es para guardar los datos por lo que se estara comunicando con el formmodel
    // Asi mismo tambien sirve para que se sete la informacion de la vista en el archivo
    override fun saveData(data: AngelFormModel) {
        if (data.NAME.isNotEmpty() && data.SURNAME.isNotEmpty() && data.NUMERO.isNotEmpty()) {
            val editor = sharedPreferences.edit()
            editor.putString(KEY_NAME, data.NAME)
            editor.putString(KEY_SURNAME, data.SURNAME)
            editor.putString(KEY_PHONE, data.NUMERO)
            editor.apply()
            callback.showData("Datos correctos")
        }
    }

    override fun returnData() {
        callback.loadData(
            AngelFormModel(
                sharedPreferences.getString(KEY_NAME, "").toString(),
                sharedPreferences.getString(KEY_SURNAME, "").toString(),
                sharedPreferences.getString(KEY_PHONE, "").toString()
            )
        )
    }
    override fun showError() {
    }
}
