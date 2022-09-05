/*
 * ProfileChat.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 04/09/2022, 22:46:50
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.profile.model

enum class ProfileChat(
    val type: TypeChat,
    val message: String,
    val date: String
)
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
