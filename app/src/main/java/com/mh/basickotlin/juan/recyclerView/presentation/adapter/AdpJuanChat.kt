/*
 * AdpJuanChat.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 31/08/2022, 14:14:05
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.recyclerView.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.ActAntonioMainBinding.bind
import com.mh.basickotlin.juan.recyclerView.presentation.Chat
import java.lang.Exception

class AdpJuanChat(private val chats: List<Chat>) : RecyclerView.Adapter<AdpJuanChat.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*
        cuando es una sola vista que queremos inflar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_juan_chat_sent, parent, false)
        return ViewHolder(view)*/
        val itemLayout = when (viewType) {
            0 -> R.layout.item_juan_chat_sent
            1 -> R.layout.item_juan_chat_received
            2 -> R.layout.item_juan_audio_sent
            3 -> R.layout.item_juan_audio_received
            4 -> R.layout.item_juan_image_sent
            5 -> R.layout.item_juan_image_received
            6 -> R.layout.item_juan_doc_sent
            7 -> R.layout.item_juan_doc_received
            else -> throw Exception("invalid type")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return chats[position].type.value
    }

    // acceder a la vista que se inflo poder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val chat = chats[position]
        holder.tvMensage.text = chat.message
        holder.tvDate.text = chat.date*/
        holder.bind(chats[position])
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(chat: Chat) {
            when (chat.type.value) {
                0 -> {
                    val tvMensage: TextView = itemView.findViewById(R.id.tvMessageSent)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDataSent)
                    tvMensage.text = chat.message
                    tvDate.text = chat.date
                }
                1 -> {
                    val tvMensage: TextView = itemView.findViewById(R.id.tvMessageReceived)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDataReceived)
                    tvMensage.text = chat.message
                    tvDate.text = chat.date
                }
                6 -> {
                    val tvMensage: TextView = itemView.findViewById(R.id.docTitle)
                    val tvDate: TextView = itemView.findViewById(R.id.docInfo)
                    tvMensage.text = chat.message
                    tvDate.text = chat.date
                }
                7 -> {
                    val tvMensage: TextView = itemView.findViewById(R.id.docTitle)
                    val tvDate: TextView = itemView.findViewById(R.id.docInfo)
                    tvMensage.text = chat.message
                    tvDate.text = chat.date
                }
            }
        }
    }

    override fun getItemCount() = chats.size
}
