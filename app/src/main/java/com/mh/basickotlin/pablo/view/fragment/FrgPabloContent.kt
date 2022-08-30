package com.mh.basickotlin.pablo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgPabloContentBinding

class FrgPabloContent : Fragment() {
    private lateinit var binding: FrgPabloContentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgPabloContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btPabloCalculator.setOnClickListener(R.id.toFrgPabloCalculator)
        binding.btPabloData.setOnClickListener(R.id.toFrgPabloData)
    }

    private fun Button.setOnClickListener(fragment: Int) {
        setOnClickListener {
            findNavController().navigate(fragment)
        }
    }
}
