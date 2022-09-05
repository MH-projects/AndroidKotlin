package com.mh.basickotlin.pablo.recycler.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgPabloRecyclerViewBinding
import com.mh.basickotlin.pablo.recycler.adapter.AdapterPabloChat
import com.mh.basickotlin.pablo.recycler.model.Chat
import com.mh.basickotlin.pablo.recycler.model.TypeChat
import com.mh.basickotlin.pablo.recycler.retrofit.RetrofitClient
import kotlinx.coroutines.launch

class FrgPabloRecyclerView : Fragment() {

    private lateinit var binding: FrgPabloRecyclerViewBinding
    private var adapter: AdapterPabloChat? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgPabloRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun createChat(typeChat: TypeChat, message: String, date: String) =
        Chat(typeChat, message, date)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        /* val chats = listOf(
             createChat(TypeChat.MESSAGE_RECEIVED, "Hola", "31/01/2022 14:43"),
             createChat(TypeChat.MESSAGE_RECEIVED, "Como estas ?", "31/01/2022 14:43"),
             createChat(TypeChat.MESSAGE_SENT, "Bien gracias", "31/01/2022 14:45"),
             createChat(TypeChat.MESSAGE_SENT, "y tu que tal?", "31/01/2022 14:45"),
             createChat(TypeChat.VOICE_RECEIVED, "", "31/01/2022 14:50"),
             createChat(TypeChat.VOICE_SENT, "", "01/09/2022 9:45"),
             createChat(TypeChat.IMAGE_SENT, "", "01/09/2022 9:50"),
             createChat(TypeChat.VOICE_RECEIVED, "", "01/09/2022 10:02")
         )*/

        binding.rvChatPablo.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            val pokemonLits = mutableListOf<Chat>()
            val response = RetrofitClient.api().getPokemon(1000)
            pokemonLits.addAll(
                response.listPokemon.map {
                    Chat(TypeChat.MESSAGE_SENT, it.name, "")
                }
            )
            adapter = AdapterPabloChat(pokemonLits)
            binding.rvChatPablo.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.pa_menu_recycler, menu)
        val searchView = menu.findItem(R.id.actionSearch).actionView as SearchView
        searchView.queryHint = "Buscar ...."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                println("Query $query")
                adapter?.filter?.filter(query)
                return true
            }
        })
    }
}
