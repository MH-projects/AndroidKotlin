package com.mh.basickotlin.pablo.recycler.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.pablo.recycler.model.Chat
import com.mh.basickotlin.pablo.recycler.model.TypeChat
import com.mh.basickotlin.databinding.FrgPabloRecyclerViewBinding
import com.mh.basickotlin.pablo.recycler.adapter.AdapterPabloChat

class FrgPabloRecyclerView : Fragment() {

    private lateinit var binding: FrgPabloRecyclerViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgPabloRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun createChat(typeChat: TypeChat, message: String, date: String) =
        Chat(typeChat, message, date)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chats = listOf(
            createChat(TypeChat.MESSAGE_RECEIVED, "Hola", "31/01/2022 14:43"),
            createChat(TypeChat.MESSAGE_RECEIVED, "Como estas ?", "31/01/2022 14:43"),
            createChat(TypeChat.MESSAGE_SENT, "Bien gracias", "31/01/2022 14:45"),
            createChat(TypeChat.MESSAGE_SENT, "y tu que tal?", "31/01/2022 14:45"),

            )

        binding.rvChatPablo.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChatPablo.adapter = AdapterPabloChat(chats)
    }
}