/*
 * FrgJosueRecycler.kt
 * Android Kotlin App
 * Created by Josue Isaias on 31/08/2022, 11:24:55
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.recyclerjc.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.R
import com.mh.basickotlin.angel.recycleview.Chat
import com.mh.basickotlin.databinding.FrgJosueRecyclerBinding
import com.mh.basickotlin.josue.recyclerjc.adapter.AdpJosueChat
import com.mh.basickotlin.josue.recyclerjc.model.ChatModel
import com.mh.basickotlin.josue.recyclerjc.model.TypeChat
import com.mh.basickotlin.josue.recyclerjc.retrofit.model.ResponsePokemon
import com.mh.basickotlin.josue.recyclerjc.retrofit.network.RetrofitClient
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FrgJosueRecycler : Fragment() {

    private lateinit var binding: FrgJosueRecyclerBinding
    private lateinit var adapter:AdpJosueChat

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

        setHasOptionsMenu(true)

        val fec = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val fechoy = fec.format(Date())

        /*val chats = listOf(
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
        )*/

        binding.rvJosContent.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            val response = RetrofitClient.callApi().getPokemon(20)

            //Ya que nos trajo el response hay que añadir los elementos en una mutablelist
            var pokeList = mutableListOf<ChatModel>()

            response.listpokemon.forEach {
                pokeList.add(ChatModel(TypeChat.MESSAGE_SENT,it.name, data = ""))
            }
            adapter = AdpJosueChat(pokeList)
            binding.rvJosContent.adapter = adapter
            /*pokeList.add(ChatModel(TypeChat.MESSAGE_SENT, response.listpokemon[0].name, data = ""))
            pokeList.add(ChatModel(TypeChat.MESSAGE_SENT, message = "Charizard", data = ""))
            pokeList.add(ChatModel(TypeChat.MESSAGE_SENT, message = "Bulbasaurt", data = ""))
            pokeList.add(ChatModel(TypeChat.MESSAGE_SENT, message = "Ditto", data = ""))*/

            //binding.rvJosContent.adapter = AdpJosueChat(pokeList)
        }

        //binding.rvJosContent.adapter = AdpJosueChat(chats)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.jc_menu_recycler,menu)

        val search = menu.findItem(R.id.actionSearch)
        val searchView = search.actionView as SearchView
        searchView.queryHint = "Buscar..."
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                //Al presionar enter
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                //Al escribir el texto
                return true
            }

        })
    }
}
