package com.mh.basickotlin.pablo.recycler.model

enum class TypeChat(val value: Int) {
    MESSAGE_SENT(1),
    MESSAGE_RECEIVED(2),
    VOICE_SENT(3),
    VOICE_RECEIVED(4),
}

data class Chat(
    val type: TypeChat,
    val message: String,
    val date: String
)
