/*
 * AdpJosueChat.kt
 * Android Kotlin App
 * Created by Josue Isaias on 31/08/2022, 14:14:41
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.recyclerjc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R
import com.mh.basickotlin.josue.recyclerjc.model.ChatModel

class AdpJosueChat(private val chats: List<ChatModel>) : RecyclerView.Adapter<AdpJosueChat.ViewHolder>(), Filterable{

    private var chatFilterable: List<ChatModel> = chats

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(chat: ChatModel) {
            when (chat.type.value) {
                0 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvMessageSent)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDataSent)
                    tvMessage.text = chat.message
                    tvDate.text = chat.data
                }
                1 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvMessageRecev)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDataRecev)
                    tvMessage.text = chat.message
                    tvDate.text = chat.data
                }
                2 -> {
                    val tvDate: TextView = itemView.findViewById(R.id.tvTimeSent)
                    tvDate.text = chat.data
                }
                3 -> {
                    val tvDataStick: TextView = itemView.findViewById(R.id.tvTimeSticker)
                    tvDataStick.text = chat.data
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            0 -> R.layout.item_josue_chat_sent
            1 -> R.layout.item_josue_chat_received
            2 -> R.layout.item_josue_voice_send
            3 -> R.layout.item_josue_img_send
            else -> throw Exception("Invalid type")
        }

        return ViewHolder(LayoutInflater.from(parent.context).inflate(itemLayout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // val chat = chats[position]
        // holder.tvMessage.text = chat.message
        // holder.tvDate.text = chat.data

        holder.bind(chatFilterable[position])

        //
    }

    override fun getItemCount() = chatFilterable.size

    override fun getItemViewType(position: Int): Int {
        return chatFilterable[position].type.value
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(query: CharSequence?): FilterResults {
                val inputText = query.toString()

                chatFilterable = if (inputText.isEmpty()){
                    chats
                }else {
                    var chatFilterableTemp:MutableList<ChatModel> = ArrayList()
                    chatFilterableTemp.clear()

                    chatFilterable.forEach {
                        if (it.message.contains(inputText)){
                            chatFilterableTemp.add(it)
                        }
                    }
                    chatFilterableTemp
                }
                val filterResult = FilterResults()
                filterResult.values = chatFilterable
                return filterResult
            }

            override fun publishResults(query: CharSequence?, results: FilterResults?) {
                chatFilterable = results?.values as List<ChatModel>
                notifyDataSetChanged()
            }

        }
    }
}
