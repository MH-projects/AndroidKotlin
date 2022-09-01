/*
 * Chat.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 31/08/2022, 14:15:40
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.recyclerview

import android.widget.ImageView

enum class TypeChat(val value:Int){
    MENSAJE_ENVIADO(0),
    MENSAJE_RECIBIDO(1),
    IMAGE_SENT(2),
    IMAGE_RECEIVED(3),
    VOICE_SENT(4),
    VOICE_RECEIVED(5)

}

data class Chat(
    val type: TypeChat,
    val mensaje: String,
    val date: String,
    val img:Int? = null
)
