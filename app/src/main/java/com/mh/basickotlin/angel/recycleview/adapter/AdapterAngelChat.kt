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
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R
import com.mh.basickotlin.angel.recycleview.Chat

class AdapterAngelChat(private val chat: List<Chat>) :
    RecyclerView.Adapter<AdapterAngelChat.ViewHolder>(), Filterable {
    private var chatfiltrable: List<Chat> = chat
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
        return chatfiltrable[position].type.value
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val chat = chats[position]
        holder.tvMessage.text = chat.message
        holder.tvDate.text = chat.date*/
        holder.bind(chatfiltrable[position])
    }

    override fun getItemCount() = chatfiltrable.size

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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val inputText = p0.toString()
                chatfiltrable = if (inputText.isEmpty()) {
                    chat
                } else {
                    var chatFiltereableTemp: MutableList<Chat> = ArrayList()
                    chatFiltereableTemp.clear()

                    chatfiltrable.forEach {
                        if (it.message.contains(inputText)) {
                            chatFiltereableTemp.add(it)
                        }
                    }
                    chatFiltereableTemp
                }
                val filterResult = FilterResults()
                filterResult.values = chatfiltrable
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                chatfiltrable = p1?.values as List<Chat>
                notifyDataSetChanged()
            }
        }
    }
}
