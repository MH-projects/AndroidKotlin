/*
 * AdapterChat.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 31/08/2022, 14:13:39
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mh.basickotlin.R

class AdapterChat (private val chat:List<Chat>): RecyclerView.Adapter<AdapterChat.ViewHolder>(),Filterable{

    private var chatfiltrable:List<Chat> = chat

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_antonio_chat_sent,parent   ,false)
        return ViewHolder(view)*/
        val typeView=when(viewType){
            0->R.layout.item_antonio_chat_sent
            1->R.layout.item_antonio_chat_received
            2->R.layout.item_antonio_chat_imagen_sent
            3->R.layout.item_antonio_chat_imagen
            4->R.layout.item_antonio_voice_sent

                else->throw  Exception("Invalido")
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(typeView,parent   ,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val msjChat = chat[position]
        holder.tvmensaje.text= msjChat.mensaje
        holder.tvdate.text=msjChat.date*/
        holder.bind(chatfiltrable[position])
    }

    override fun getItemCount(): Int {
        return chatfiltrable.size
    }

    override fun getItemViewType(position: Int)= chatfiltrable[position].type.value

    //si se elimina - se eliminara la clase
    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        fun bind(chat:Chat){
            when(chat.type.value){
                TypeChat.MENSAJE_ENVIADO.value->{
                    val tvmensaje:TextView=itemView.findViewById(R.id.tvMessageSent)
                    val tvdate:TextView=itemView.findViewById(R.id.tvdate)
                    tvmensaje.text=chat.mensaje
                    tvdate.text=chat.date
                }
                TypeChat.MENSAJE_RECIBIDO.value->{
                    val tvmensajeR:TextView=itemView.findViewById(R.id.tvMessagerecived)
                    val tvdateR:TextView=itemView.findViewById(R.id.tvdaterecived)
                    tvmensajeR.text=chat.mensaje
                    tvdateR.text=chat.date
                }
                TypeChat.IMAGE_SENT.value->{
                    val imgSent:ImageView=itemView.findViewById(R.id.imgChatSent)
                    val tvmsj:TextView=itemView .findViewById(R.id.tvmsjimg)
                    val tvdateR:TextView=itemView.findViewById(R.id.tvdateimg)
                    chat.img?.let {
                        imgSent.setImageResource(it)
                    }
                    tvmsj.text=chat.mensaje
                    tvdateR.text=chat.date
                }
                TypeChat.IMAGE_RECEIVED.value->{
                    val imgSent:ImageView=itemView.findViewById(R.id.imgChatRecived)
                    val tvmsj:TextView=itemView .findViewById(R.id.tvmsjimgRecived)
                    val tvdateR:TextView=itemView.findViewById(R.id.tvdateimgRecuved)
                    chat.img?.let {
                        imgSent.setImageResource(it)
                    }
                    tvmsj.text=chat.mensaje
                    tvdateR.text=chat.date
                }
                TypeChat.VOICE_SENT.value->{
                    val tvdateR:TextView=itemView.findViewById(R.id.tvdateivoice)

                    tvdateR.text=chat.date
                }
            }
        }



    }

   override fun getFilter():Filter{
        return object :Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                    val inputText=p0.toString()
                chatfiltrable= if (inputText.isEmpty()){
                    chat
                }else{
                    var chatFiltereableTemp:MutableList<Chat> = ArrayList()
                    chatFiltereableTemp.clear()

                    chatfiltrable.forEach {
                        if (it.mensaje.contains(inputText)){
                            chatFiltereableTemp.add(it)
                        }
                    }
                    chatFiltereableTemp
                }
                val filterResult=FilterResults()
                filterResult.values=chatfiltrable
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                chatfiltrable=p1?.values as List<Chat>
                notifyDataSetChanged()
            }

        }
    }
}