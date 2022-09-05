/*
 * FrgManuelContent.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 01/09/2022, 10:16:56
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel._main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgManuelContentBinding

class FrgManuelContent : Fragment() {

    private lateinit var binding: FrgManuelContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgManuelContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPresentation.setOnClickListener {
            findNavController().navigate(R.id.toFrgManuelPresentation)
        }

        binding.btnCalcultator.setOnClickListener {
            findNavController().navigate(R.id.toFrgManuelCalculator)
        }

        binding.btnRecyclerCardView.setOnClickListener {
            findNavController().navigate(R.id.toFrgManuelRecyclerView)
        }
    }
}
