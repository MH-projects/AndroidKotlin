/*
 * FrgManuelCalculator.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 01/09/2022, 09:57:26
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.calculator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgManuelCalculatorBinding
import com.mh.basickotlin.manuel.calculator.viewmodel.ManuelCalculatorViewModel

class FrgManuelCalculator : Fragment() {

    private lateinit var binding: FrgManuelCalculatorBinding
    private lateinit var viewModel: ManuelCalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ManuelCalculatorViewModel()

        binding = FrgManuelCalculatorBinding.inflate(inflater, container, false)
        binding.vm = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.textOperation.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvOperation.text = it
            }
        }

        viewModel.textResult.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvResult.text = it
            }
        }
    }
}
