/*
 * AdpManuelChat.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 14:12:28
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.recycler.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R
import com.mh.basickotlin.manuel.recycler.domain.IChatBinding
import com.mh.basickotlin.manuel.recycler.presentation.model.Chat
import com.mh.basickotlin.manuel.recycler.presentation.model.TypeChat.*

class AdpManuelChat(private val chats: List<Chat>) :
    RecyclerView.Adapter<AdpManuelChat.ViewHolder>(), IChatBinding, Filterable {

    private var chatFilterable: List<Chat> = chats

    override fun getItemCount() = chatFilterable.size

    override fun getItemViewType(position: Int) = chatFilterable[position].type.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            1 -> R.layout.item_mh_received_message
            2 -> R.layout.item_mh_received_voice
            3 -> R.layout.item_mh_received_img
            1 + 100 -> R.layout.item_mh_sent_message
            2 + 100 -> R.layout.item_mh_sent_voice
            3 + 100 -> R.layout.item_mh_sent_img
            else -> throw Exception("Invalid type")
        }

        return ViewHolder(LayoutInflater.from(parent.context).inflate(itemLayout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatFilterable[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(chat: Chat) {
            when (chat.type.value) {
                RECEIVED_MESSAGE.value, SENT_MESSAGE.value -> bindMessage(itemView, chat)
                RECEIVED_IMAGE.value, SENT_IMAGE.value -> bindImage(itemView, chat)
                RECEIVED_VOICE.value, SENT_VOICE.value -> bindVoice(itemView, chat)
            }
        }
    }

    override fun bindMessage(messageView: View, chat: Chat) {
        messageView.findViewById<TextView>(R.id.tvMessage).text = chat.message
        messageView.findViewById<TextView>(R.id.tvDate).text = chat.date
    }

    override fun bindVoice(voiceView: View, chat: Chat) {
        voiceView.findViewById<TextView>(R.id.tvDate).text = chat.date
    }

    override fun bindImage(imageView: View, chat: Chat) {
        chat.image?.let {
            imageView.findViewById<ImageView>(R.id.ivImage).setImageResource(it)
        }
        imageView.findViewById<TextView>(R.id.tvImageDesc).text = chat.message
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(query: CharSequence?): FilterResults {
                val inputText = query.toString()

                chatFilterable = if (inputText.isEmpty()) {
                    chats
                } else {
                    val chatFilterableTemp: MutableList<Chat> = ArrayList()
                    chatFilterableTemp.clear()

                    chatFilterable.forEach {
                        if (it.message.contains(inputText)) {
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
                chatFilterable = results?.values as List<Chat>
                notifyDataSetChanged()
            }
        }
    }
}
