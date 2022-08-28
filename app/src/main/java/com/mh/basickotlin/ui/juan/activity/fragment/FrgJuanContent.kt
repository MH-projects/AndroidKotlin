package com.mh.basickotlin.ui.juan.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgJuanContentBinding

class FrgJuanContent : Fragment() {
    private lateinit var binding: FrgJuanContentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgJuanContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnCalculator).setOnClickListener {
            findNavController().navigate(R.id.frgJuanCalculator)
        }
    }
}
