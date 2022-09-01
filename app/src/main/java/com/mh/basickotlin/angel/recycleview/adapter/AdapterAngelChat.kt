/*
 * AdapterAngelChat.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 15:04:33
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.recycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R
import com.mh.basickotlin.angel.recycleview.Chat

class AdapterAngelChat(private val chats: List<Chat>) :
    RecyclerView.Adapter<AdapterAngelChat.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /* val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_angel_chat_sent, parent, false)
        return ViewHolder(view)*/

        val itemLayout = when (viewType) {
            0 -> R.layout.item_angel_chat_sent
            1 -> R.layout.item_angel_chat_received
            2 -> R.layout.item_angel_chat_sent_voice
            3 -> R.layout.item_angel_chat_received_voice
            4 -> R.layout.item_angel_chat_sent_download
            5 -> R.layout.item_angel_chat_received_download

            else -> throw Exception("Tipo invalido")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return chats[position].type.value
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val chat = chats[position]
        holder.tvMessage.text = chat.message
        holder.tvDate.text = chat.date*/
        holder.bind(chats[position])
    }

    override fun getItemCount() = chats.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(chat: Chat) {
            when (chat.type.value) {
                0 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvMessageSent)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDate)
                    tvMessage.text = chat.message
                    tvDate.text = chat.date
                }
                1 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvMessageReceived)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDateMessageReceived)
                    tvMessage.text = chat.message
                    tvDate.text = chat.date
                }
                2 -> {
                    val tvDate: TextView = itemView.findViewById(R.id.tvVoiceSentDAte)
                    tvDate.text = chat.date
                }
                3 -> {
                    val tvDate: TextView = itemView.findViewById(R.id.tvDateVoiceReceived)
                    tvDate.text = chat.date
                }
                4 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvDownloadSent)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDownloadDateSent)
                    tvMessage.text = chat.message
                    tvDate.text = chat.date
                }
                5 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvDownloadReceived)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDateDownloadReceived)
                    tvMessage.text = chat.message
                    tvDate.text = chat.date
                }
            }
        }
    }
}
