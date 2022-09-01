package com.mh.basickotlin.pablo.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R
import com.mh.basickotlin.pablo.recycler.model.Chat
import com.mh.basickotlin.pablo.recycler.model.TypeChat

class AdapterPabloChat(private val chats: List<Chat>) :
    RecyclerView.Adapter<AdapterPabloChat.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemLayout = when (viewType) {
            1 -> R.layout.item_pablo_message_sent
            2 -> R.layout.item_pablo_message_received
            else -> throw Exception("Tipo invalido")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chats[position])
    }

    override fun getItemCount() = chats.size
    override fun getItemViewType(position: Int): Int {
        return chats[position].type.value
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var tvMessage: TextView
        lateinit var tvDate: TextView
        fun bind(chat: Chat) {

            when (chat.type) {
                TypeChat.MESSAGE_SENT -> {
                    tvMessage = itemView.findViewById(R.id.tvMessageSent)
                    tvDate = itemView.findViewById(R.id.tvDate)

                }
                TypeChat.MESSAGE_RECEIVED -> {
                    tvMessage = itemView.findViewById(R.id.tvMessageReceived)
                    tvDate = itemView.findViewById(R.id.tvDateMessageReceived)

                }
                else -> throw Exception("Tipo invalido")

            }
            tvMessage.text = chat.message
            tvDate.text = chat.date
        }

    }
}