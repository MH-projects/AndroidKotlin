/*
 * Chat.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 31/08/2022, 14:16:03
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.recyclerView.presentation
enum class TypeChat(val value: Int) {
    MESSAGE_SENT(0),
    MESSAGE_RECEIVED(1),
    VOICE_SENT(2),
    VOICE_RECEIVED(3),
    IMAGE_SENT(4),
    IMAGE_RECEIVED(5),
    DOC_SENT(6),
    DOC_RECEIVED(7),
}
data class Chat(
    val type: TypeChat,
    val message: String,
    val date: String
)
