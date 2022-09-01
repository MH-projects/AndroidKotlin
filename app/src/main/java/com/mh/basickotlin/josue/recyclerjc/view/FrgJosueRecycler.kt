/*
 * FrgJosueRecycler.kt
 * Android Kotlin App
 * Created by Josue Isaias on 31/08/2022, 11:24:55
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.recyclerjc.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.databinding.FrgJosueRecyclerBinding
import com.mh.basickotlin.josue.recyclerjc.adapter.AdpJosueChat
import com.mh.basickotlin.josue.recyclerjc.model.ChatModel
import com.mh.basickotlin.josue.recyclerjc.model.TypeChat
import java.text.SimpleDateFormat
import java.util.*

class FrgJosueRecycler : Fragment() {

    private lateinit var binding: FrgJosueRecyclerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgJosueRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fec = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val fechoy = fec.format(Date())

        val chats = listOf(
            ChatModel(TypeChat.MESSAGE_SENT, "Hola", fechoy.toString()),
            ChatModel(TypeChat.MESSAGE_SENT, "¿Como", fechoy.toString()),
            ChatModel(TypeChat.MESSAGE_SENT, "Estas?", fechoy.toString()),
            ChatModel(TypeChat.MESSAGE_RECEIVED, "bien y tu ?", fechoy.toString()),
            ChatModel(TypeChat.MESSAGE_RECEIVED, ":)", fechoy.toString()),
            ChatModel(TypeChat.VOICE_SENT, "", "05:00"),
            ChatModel(TypeChat.VOICE_SENT, "", "00:30"),
            ChatModel(TypeChat.MESSAGE_RECEIVED, "Omg", fechoy.toString()),
            ChatModel(TypeChat.MESSAGE_RECEIVED, "O.O", fechoy.toString()),
            ChatModel(TypeChat.STICKER_SENT, "", fechoy.toString())
        )

        binding.rvJosContent.layoutManager = LinearLayoutManager(requireContext())
        binding.rvJosContent.adapter = AdpJosueChat(chats)
    }
}
