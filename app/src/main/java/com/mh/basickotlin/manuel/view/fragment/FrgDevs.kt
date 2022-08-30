package com.mh.basickotlin.manuel.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgDevsBinding

class FrgDevs : Fragment() {

    private lateinit var binding: FrgDevsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgDevsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnManuel.setOnClickListener {
            findNavController().navigate(R.id.toFrgManuelContent)
        }

        view.findViewById<Button>(R.id.btnAngel).setOnClickListener {
            findNavController().navigate(R.id.toFrgAngelMain)
        }

        view.findViewById<Button>(R.id.btnPablo).setOnClickListener {
            findNavController().navigate(R.id.toFrgPabloContent)
        }

        view.findViewById<Button>(R.id.btnAntonio).setOnClickListener {
            findNavController().navigate(R.id.toFrgAntonioContent)
        }

        view.findViewById<Button>(R.id.btnJosue).setOnClickListener {
            findNavController().navigate(R.id.frgJosueContent)
        }
        view.findViewById<Button>(R.id.btnJuan).setOnClickListener {
            findNavController().navigate(R.id.toFrgJuanContent)
        }
    }
}
