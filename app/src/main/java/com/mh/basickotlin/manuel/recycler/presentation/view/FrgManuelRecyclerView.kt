/*
 * FrgManuelRecyclerView.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 13:47:17
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.recycler.presentation.view

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgManuelRecyclerViewBinding
import com.mh.basickotlin.manuel.recycler.presentation.adapter.AdpManuelChat
import com.mh.basickotlin.manuel.recycler.presentation.model.Chat
import com.mh.basickotlin.manuel.recycler.presentation.model.TypeChat
import com.mh.mhapp.data.network.RetrofitClient
import kotlinx.coroutines.launch

class FrgManuelRecyclerView : Fragment() {

    private lateinit var binding: FrgManuelRecyclerViewBinding

    private lateinit var adapter: AdpManuelChat

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgManuelRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        /*
        val chats = listOf(
            Chat(TypeChat.SENT_MESSAGE, message = "Hola", date = "31/08/2022 14:34"),
            Chat(TypeChat.SENT_MESSAGE, message = "Cómo estás?", date = "31/08/2022 14:35"),
            Chat(TypeChat.SENT_MESSAGE, message = "Qué haces?", date = "31/08/2022 14:38"),
            Chat(TypeChat.RECEIVED_MESSAGE, message = "Hola", date = "31/08/2022 14:38"),
            Chat(TypeChat.RECEIVED_VOICE, date = "31/08/2022 15:38"),
            Chat(
                type = TypeChat.RECEIVED_IMAGE,
                date = "31/08/2022 15:38",
                image = R.drawable.img_mh_landscape,
                message = "Mira esta bonita foto."
            ),
            Chat(
                type = TypeChat.SENT_IMAGE,
                date = "31/08/2022 15:38",
                image = R.drawable.img_mh_landscape_2,
                message = "Esta más chida esta"
            ),
            Chat(TypeChat.SENT_VOICE, date = "31/08/2022 15:38")
        )
*/
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            val response = RetrofitClient.api().getPokemon(1000)
            val pokemonList = mutableListOf<Chat>()

//            pokemonList.addAll(
//                response.listPokemon.map {
//                    Chat(TypeChat.SENT_MESSAGE, message = it.name, date = "")
//                }
//            )

            response.listPokemon.forEach {
                pokemonList.add(Chat(TypeChat.SENT_MESSAGE, message = it.name, date = ""))
            }

            adapter = AdpManuelChat(pokemonList)
            binding.rvChat.adapter = adapter
        }

        // binding.rvChat.adapter = AdpManuelChat(chats)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.mh_menu_recycler, menu)

        val searchView = menu.findItem(R.id.actionSearch).actionView as SearchView

        searchView.queryHint = "Buscar..."

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                println("Query: $query")
                adapter.filter.filter(query)
                return true
            }
        })
    }
}
