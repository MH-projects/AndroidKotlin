package com.mh.basickotlin.angel.recycleview.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicationangel.data.network.RetrofitClientPokemon
import com.mh.basickotlin.R
import com.mh.basickotlin.angel.recycleview.Chat
import com.mh.basickotlin.angel.recycleview.Typechat
import com.mh.basickotlin.angel.recycleview.adapter.AdapterAngelChat
import com.mh.basickotlin.databinding.FrgAngelRecycleViewBinding
import kotlinx.coroutines.launch

class frgAngelRecycleView : Fragment() {

    private lateinit var binding: FrgAngelRecycleViewBinding
    private  var adapter: AdapterAngelChat? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAngelRecycleViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun createChat(typechat: Typechat, message: String, date: String): Chat {
        return Chat(typechat, message, date)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        /*
        val chats = listOf(
            createChat(Typechat.VOICE_RECEIVED, "", "31/01/2022 14:43"),
            createChat(Typechat.MESSAGE_SENT, "Deja te lo mando", "31/01/2022 14:45"),
            createChat(Typechat.DOWNLOAD_SENT, "Español.pdf", "31/01/2022 14:45"),
            createChat(Typechat.DOWNLOAD_RECEIVED, "Español.pdf", "31/01/2022 14:47"),
            createChat(
                Typechat.MESSAGE_RECEIVED,
                "Gracias! pero yo tengo una mejor version",
                "31/02/2022 14:50"
            )
        )
*/ binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            val response = RetrofitClientPokemon.api().get(150)
            var pokenList = mutableListOf<Chat>()
            response.listPokemon.forEach {
                pokenList.add(Chat(Typechat.MESSAGE_SENT, message = "${it.name}", date = ""))
            }
            adapter = AdapterAngelChat(pokenList)
            binding.rvChat.adapter = adapter
        }

        /*
        var pokenList = mutableListOf<Chat>()
        pokenList.add(Chat(Typechat.MESSAGE_SENT, message = "Pika", date = " "))
        pokenList.add(Chat(Typechat.MESSAGE_RECEIVED, message = "Charizard", date = " "))
        pokenList.add(Chat(Typechat.MESSAGE_RECEIVED, message = "Toggepi", date = " "))
        pokenList.add(Chat(Typechat.MESSAGE_RECEIVED, message = "Squirtle", date = " "))
        binding.rvChat.adapter = AdapterAngelChat(pokenList)*/
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ab_menu_recycler, menu)
        val search = menu.findItem(R.id.ActionSearch)
        val searchView = search.actionView as SearchView
        searchView.queryHint = "Buscar..."

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                println("$newText")
                adapter?.filter?.filter(newText)
                return true
            }
        })
    }
}
