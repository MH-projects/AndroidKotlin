package com.mh.basickotlin.pablo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mh.basickotlin.databinding.FrgPabloCalculatorBinding
import com.mh.basickotlin.pablo.viewmodel.PabloCalculatorViewModel

class FrgPabloCalculator : Fragment() {
    private lateinit var binding: FrgPabloCalculatorBinding
    private val viewModel: PabloCalculatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FrgPabloCalculatorBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.autoResult(false)
        binding.cbAutoResult.setOnCheckedChangeListener { _, isChecked ->
            viewModel.autoResult(isChecked)
        }
        viewModel.textToast.observe(viewLifecycleOwner) {
            Toast.makeText(
                context,
                it,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
