/*
 * FrgAntonioRecyclerCard.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 31/08/2022, 11:22:01
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.view.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.R
import com.mh.basickotlin.antonio.recyclerview.AdapterChat
import com.mh.basickotlin.antonio.recyclerview.Chat
import com.mh.basickotlin.antonio.recyclerview.TypeChat
import com.mh.basickotlin.databinding.FrgAntonioRecyclerCardBinding

class FrgAntonioRecyclerCard : Fragment() {

    private lateinit var binding:FrgAntonioRecyclerCardBinding

    private fun creaChat(typeChat: TypeChat,mensaje:String,date:String, img:Int)=
        Chat(typeChat,mensaje,date)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FrgAntonioRecyclerCardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val Chat= listOf(
            creaChat(TypeChat.MENSAJE_ENVIADO,"Hola","14:34",img=0),
            creaChat(TypeChat.MENSAJE_ENVIADO,"como estas","14:34",img=0),
            creaChat(TypeChat.MENSAJE_ENVIADO,"?","14:34",img=0),
            creaChat(TypeChat.MENSAJE_RECIBIDO,"HOLA","14:34",img=0),
            creaChat(TypeChat.MENSAJE_RECIBIDO,"Bien y tu"," 14:34",img=0),
            creaChat(TypeChat.MENSAJE_RECIBIDO,"?"," 14:34",img=0),
            creaChat(TypeChat.MENSAJE_ENVIADO,"muy bien gracias","14:34",img=0),
            creaChat(typeChat =TypeChat.IMAGE_SENT, mensaje = "el nuevo juego de god of war", date = " 14:34",img = R.drawable.call),
            creaChat(typeChat =TypeChat.IMAGE_RECEIVED, mensaje = "es mejor este", date = " 14:34",img = R.drawable.call),
            creaChat(typeChat =TypeChat.VOICE_SENT, mensaje = "", date = " 14:34",img =0 )
        )

        binding.recyclerChat.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerChat.adapter=AdapterChat(Chat)
    }


}