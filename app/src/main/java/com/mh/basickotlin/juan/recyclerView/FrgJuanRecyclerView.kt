/*
 * FrgJuanRecyclerView.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 31/08/2022, 10:45:18
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.databinding.FrgJuanRecyclerViewBinding
import com.mh.basickotlin.juan.recyclerView.presentation.Chat
import com.mh.basickotlin.juan.recyclerView.presentation.TypeChat
import com.mh.basickotlin.juan.recyclerView.presentation.adapter.AdpJuanChat
import java.util.*
class FrgJuanRecyclerView : Fragment() {
    private lateinit var binding: FrgJuanRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgJuanRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun createChat(typeChat: TypeChat, message: String, date: String) = Chat(typeChat, message, date)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chats = listOf(
            createChat(TypeChat.MESSAGE_SENT, "hola 1", "31/08/2022 10:45:18"),
            createChat(TypeChat.VOICE_SENT, "", ""),
            createChat(TypeChat.VOICE_RECEIVED, "", ""),
            createChat(TypeChat.IMAGE_RECEIVED, "", ""),
            createChat(TypeChat.DOC_SENT, "PDF.pdf", "21 MB PDF"),
            createChat(TypeChat.MESSAGE_RECEIVED, "hola 3", "31/08/2022 10:45:18"),
            createChat(TypeChat.IMAGE_SENT, "", ""),
            createChat(TypeChat.DOC_RECEIVED, "PDF.pdf", "21 MB")
        )

        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.adapter = AdpJuanChat(chats)
    }
}
