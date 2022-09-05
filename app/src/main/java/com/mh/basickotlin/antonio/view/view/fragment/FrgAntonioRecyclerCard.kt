/*
 * FrgAntonioRecyclerCard.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 31/08/2022, 11:22:01
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.view.view.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.antonioapp.data.network.RetrofitDataClient
import com.mh.basickotlin.R
import com.mh.basickotlin.antonio.recyclerview.AdapterChat
import com.mh.basickotlin.antonio.recyclerview.Chat
import com.mh.basickotlin.antonio.recyclerview.TypeChat
import com.mh.basickotlin.databinding.FrgAntonioRecyclerCardBinding
import kotlinx.coroutines.launch

class FrgAntonioRecyclerCard : Fragment() {

    private lateinit var binding:FrgAntonioRecyclerCardBinding
    private var adapter:AdapterChat?=null

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
        setHasOptionsMenu(true)

       /* val Chat= listOf(
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
        )*/

        binding.recyclerChat.layoutManager=LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            //for (i in 0..RetrofitDataClient.api())
            val response=RetrofitDataClient.api().getpokemon(150)
            var pokemonList= mutableListOf<Chat>()
            /*response.listPokemon.forEach {
                pokemonList.add(Chat(TypeChat.MENSAJE_ENVIADO, mensaje = "${it.name}", date = ""))
            }*/

            //  binding.recyclerChat.adapter=AdapterChat(pokemonList)
            for(i in 0..response.listPokemon.size -1){
                    pokemonList.add(Chat(TypeChat.MENSAJE_ENVIADO, mensaje = "${response.listPokemon[i].name}", date = ""))

            }
            //binding.recyclerChat.adapter=AdapterChat(pokemonList)
            adapter= AdapterChat(pokemonList)
            binding.recyclerChat.adapter=adapter

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.ab_menu_recycler,menu)

        val search=menu.findItem(R.id.ActionSearch).actionView as SearchView

        search.queryHint="Buscar..."
        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                println("Query $newText")
                adapter?.filter?.filter(newText)

                return true
            }

        })

    }

}