/*
 * FrgJuanRecyclerView.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 31/08/2022, 10:45:18
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.recyclerView

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgJuanRecyclerViewBinding
import com.mh.basickotlin.juan.recyclerView.presentation.Chat
import com.mh.basickotlin.juan.recyclerView.presentation.TypeChat
import com.mh.basickotlin.juan.recyclerView.presentation.adapter.AdpJuanChat
import com.mh.basickotlin.juan.recyclerView.retrofit.RetrofitClient
import kotlinx.coroutines.launch
import java.util.*
class FrgJuanRecyclerView : Fragment() {
    private lateinit var binding: FrgJuanRecyclerViewBinding
    private lateinit var adapter: AdpJuanChat
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgJuanRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun createChat(typeChat: TypeChat, message: String, date: String) = Chat(typeChat, message, date)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        /*
        val chats = listOf(
            createChat(TypeChat.MESSAGE_SENT, "hola 1", "31/08/2022 10:45:18"),
            createChat(TypeChat.VOICE_SENT, "", ""),
            createChat(TypeChat.VOICE_RECEIVED, "", ""),
            createChat(TypeChat.IMAGE_RECEIVED, "", ""),
            createChat(TypeChat.DOC_SENT, "PDF.pdf", "21 MB PDF"),
            createChat(TypeChat.MESSAGE_RECEIVED, "hola 3", "31/08/2022 10:45:18"),
            createChat(TypeChat.IMAGE_SENT, "", ""),
            createChat(TypeChat.DOC_RECEIVED, "PDF.pdf", "21 MB")
        )
        */
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        // binding.rvChat.adapter = AdpJuanChat(chats)
        lifecycleScope.launch {
            val response = RetrofitClient.api().getPokemon(20)
            var pockemonList = mutableListOf<Chat>()
            /* checar los map
            pockemonList.addAll(
                response.results.map {
                    pockemonList.add(Chat(TypeChat.MESSAGE_SENT, message = "Pikachu", date = ""))
                }
            )
             */
            for (i in 0..response.results.size - 1) {
                pockemonList.add(Chat(TypeChat.MESSAGE_SENT, message = "${response.results[i].name}", date = ""))
            }
            adapter = AdpJuanChat(pockemonList)
            binding.rvChat.adapter = adapter
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_recycler, menu)
        val searchView = menu.findItem(R.id.actionSe).actionView as SearchView
        searchView.queryHint = "Buscar.."
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
