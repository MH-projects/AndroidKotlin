/*
 * Chat.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 14:15:21
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.recycler.presentation.model

enum class TypeChat(val value: Int) {
    RECEIVED_MESSAGE(1),
    RECEIVED_VOICE(2),
    RECEIVED_IMAGE(3),

    SENT_MESSAGE(1 + 100),
    SENT_VOICE(2 + 100),
    SENT_IMAGE(3 + 100),
}

data class Chat(
    val type: TypeChat,
    val date: String,
    val message: String = "",
    val image: Int? = null
)
