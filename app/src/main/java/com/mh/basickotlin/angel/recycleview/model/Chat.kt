/*
 * Chat.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 15:07:49
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.recycleview

enum class Typechat(val value: Int) {
    MESSAGE_SENT(0),
    MESSAGE_RECEIVED(1),
    VOICE_SENT(2),
    VOICE_RECEIVED(3),
    DOWNLOAD_SENT(4),
    DOWNLOAD_RECEIVED(5)
}

data class Chat(
    val type: Typechat,
    val message: String,
    val date: String
)
