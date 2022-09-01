/*
 * IChatBinding.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 16:13:41
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.recycler.domain

import android.view.View
import com.mh.basickotlin.manuel.recycler.presentation.model.Chat

interface IChatBinding {

    fun bindMessage(messageView: View, chat: Chat)
    fun bindVoice(voiceView: View, chat: Chat)
    fun bindImage(imageView: View, chat: Chat)
}
