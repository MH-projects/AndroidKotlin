/*
 * FrgAngelRecycleView.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 15:03:53
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.recycleview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.angel.recycleview.Chat
import com.mh.basickotlin.angel.recycleview.Typechat
import com.mh.basickotlin.angel.recycleview.adapter.AdapterAngelChat
import com.mh.basickotlin.databinding.FrgAngelRecycleViewBinding

class frgAngelRecycleView : Fragment() {

    private lateinit var binding: FrgAngelRecycleViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAngelRecycleViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun createChat(typechat: Typechat, message: String, date: String): Chat {
        return Chat(typechat, message, date)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chats = listOf(
            createChat(Typechat.VOICE_RECEIVED, "", "31/01/2022 14:43"),
            createChat(Typechat.MESSAGE_SENT, "Deja te lo mando", "31/01/2022 14:45"),
            createChat(Typechat.DOWNLOAD_SENT, "Español.pdf", "31/01/2022 14:45"),
            createChat(Typechat.DOWNLOAD_RECEIVED, "Español.pdf", "31/01/2022 14:47"),
            createChat(
                Typechat.MESSAGE_RECEIVED,
                "Gracias! pero yo tengo una mejor version",
                "31/02/2022 14:50"
            )
        )

        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.adapter = AdapterAngelChat(chats)
    }
}
