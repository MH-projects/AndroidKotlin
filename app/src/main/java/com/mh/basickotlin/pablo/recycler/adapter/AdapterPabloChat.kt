package com.mh.basickotlin.pablo.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R
import com.mh.basickotlin.pablo.recycler.model.Chat
import com.mh.basickotlin.pablo.recycler.model.TypeChat

class AdapterPabloChat(private val chats: List<Chat>) :
    RecyclerView.Adapter<AdapterPabloChat.ViewHolder>(), Filterable {
    private var chatFilterable: List<Chat> = chats

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            1 -> R.layout.item_pablo_message_sent
            2 -> R.layout.item_pablo_message_received
            3 -> R.layout.item_pablo_voice_sent
            4 -> R.layout.item_pablo_voice_received
            5 -> R.layout.item_pablo_image_sent
            else -> throw Exception("Tipo invalido")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatFilterable[position])
    }

    override fun getItemCount() = chatFilterable.size
    override fun getItemViewType(position: Int): Int {
        return chatFilterable[position].type.value
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var tvMessage: TextView
        lateinit var tvDate: TextView
        fun bind(chat: Chat) {
            when (chat.type) {
                TypeChat.MESSAGE_SENT -> {
                    tvMessage = itemView.findViewById(R.id.tvMessageSent)
                    tvDate = itemView.findViewById(R.id.tvDate)
                    tvMessage.text = chat.message
                }
                TypeChat.MESSAGE_RECEIVED -> {
                    tvMessage = itemView.findViewById(R.id.tvMessageReceived)
                    tvDate = itemView.findViewById(R.id.tvDateMessageReceived)
                    tvMessage.text = chat.message
                }
                TypeChat.VOICE_SENT -> {
                    tvDate = itemView.findViewById(R.id.tvVoicePabloDate)
                }
                TypeChat.VOICE_RECEIVED -> {
                    tvDate = itemView.findViewById(R.id.tvDateVoiceReceived)
                }
                TypeChat.IMAGE_SENT -> {
                    tvDate = itemView.findViewById(R.id.tvImagePabloDate)
                }
                else -> throw Exception("Tipo invalido")
            }

            tvDate.text = chat.date
        }
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
                        if (it.message.contains(inputText)) chatFilterableTemp.add(it)
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
