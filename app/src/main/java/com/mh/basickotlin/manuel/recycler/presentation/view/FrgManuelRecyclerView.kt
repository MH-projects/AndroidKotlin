/*
 * FrgManuelRecyclerView.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 13:47:17
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.recycler.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgManuelRecyclerViewBinding
import com.mh.basickotlin.manuel.recycler.presentation.adapter.AdpManuelChat
import com.mh.basickotlin.manuel.recycler.presentation.model.Chat
import com.mh.basickotlin.manuel.recycler.presentation.model.TypeChat

class FrgManuelRecyclerView : Fragment() {

    private lateinit var binding: FrgManuelRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgManuelRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chats = listOf(
            Chat(TypeChat.SENT_MESSAGE, message = "Hola", date = "31/08/2022 14:34"),
            Chat(TypeChat.SENT_MESSAGE, message = "Cómo estás?", date = "31/08/2022 14:35"),
            Chat(TypeChat.SENT_MESSAGE, message = "Qué haces?", date = "31/08/2022 14:38"),
            Chat(TypeChat.RECEIVED_MESSAGE, message = "Hola", date = "31/08/2022 14:38"),
            Chat(TypeChat.RECEIVED_VOICE, date = "31/08/2022 15:38"),
            Chat(
                type = TypeChat.RECEIVED_IMAGE,
                date = "31/08/2022 15:38",
                image = R.drawable.img_mh_landscape,
                message = "Mira esta bonita foto."
            ),
            Chat(
                type = TypeChat.SENT_IMAGE,
                date = "31/08/2022 15:38",
                image = R.drawable.img_mh_landscape_2,
                message = "Esta más chida esta"
            ),
            Chat(TypeChat.SENT_VOICE, date = "31/08/2022 15:38")
        )

        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.adapter = AdpManuelChat(chats)
    }
}
