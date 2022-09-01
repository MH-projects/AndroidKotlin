/*
 * ChatModel.kt
 * Android Kotlin App
 * Created by Josue Isaias on 31/08/2022, 14:16:51
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.recyclerjc.model

enum class TypeChat(val value: Int) {
    MESSAGE_SENT(0),
    MESSAGE_RECEIVED(1),
    VOICE_SENT(2),
    STICKER_SENT(3)
}
data class ChatModel(
    val type: TypeChat,
    val message: String,
    val data: String
)
