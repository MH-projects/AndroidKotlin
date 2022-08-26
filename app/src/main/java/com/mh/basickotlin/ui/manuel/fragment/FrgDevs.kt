package com.mh.basickotlin.ui.manuel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            findNavController().navigate(R.id.toFrgManuelCalculator)
        }
        view.findViewById<Button>(R.id.btnAngel).setOnClickListener {
            findNavController().navigate(R.id.frgAngelMain)
        }
    }
}
