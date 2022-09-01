package com.mh.basickotlin.angel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mh.basickotlin.angel.model.Numbers
import com.mh.basickotlin.angel.model.Operators
import com.mh.basickotlin.angel.presenter.AngelCalcContract
import com.mh.basickotlin.angel.viewmodel.AngelCalculatorVM
import com.mh.basickotlin.databinding.FrgAngelCalculatorBinding

class FrgAngelCalculator : Fragment() {
    private lateinit var binding: FrgAngelCalculatorBinding
    private lateinit var presenter: AngelCalcContract.presenter
    val viewModel: AngelCalculatorVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgAngelCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Manera de saber si el checkblox esta seleccionado y el guin bajo funciona para un parametro sin usar
        binding.cbAuResult.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnResultado.visibility = View.INVISIBLE
            } else {
                binding.btnResultado.visibility = View.VISIBLE
            }
            viewModel.autoResult(isChecked)
        }

        viewModel.textResult.observe(viewLifecycleOwner) {
            binding.tvResultNumber.text = it
        }
        viewModel.textOperation.observe(viewLifecycleOwner) {
            binding.tvOperation.text = it
        }
        binding.btnNumCero.setOnClickListener() { viewModel.checkDigit(Numbers.Zero) }
        binding.btnNumOne.setOnClickListener() { viewModel.checkDigit(Numbers.One) }
        binding.btnNumTwo.setOnClickListener() { viewModel.checkDigit(Numbers.Two) }
        binding.btnNumThree.setOnClickListener() { viewModel.checkDigit(Numbers.Three) }
        binding.btnNumFour.setOnClickListener() { viewModel.checkDigit(Numbers.Four) }
        binding.btnNumFive.setOnClickListener() { viewModel.checkDigit(Numbers.Five) }
        binding.btnNumSix.setOnClickListener() { viewModel.checkDigit(Numbers.Six) }
        binding.btnNumSeven.setOnClickListener() { viewModel.checkDigit(Numbers.Seven) }
        binding.btnNumEight.setOnClickListener() { viewModel.checkDigit(Numbers.Eight) }
        binding.btnNumNine.setOnClickListener() { viewModel.checkDigit(Numbers.Nine) }

        binding.btnMore.setOnClickListener { viewModel.checkOperator(Operators.Plus) }
        binding.btnLess.setOnClickListener { viewModel.checkOperator(Operators.Less) }
        binding.btnBy.setOnClickListener { viewModel.checkOperator(Operators.By) }
        binding.btnBetween.setOnClickListener { viewModel.checkOperator(Operators.Div) }

        binding.btnClean.setOnClickListener { viewModel.clear() }
        binding.btnDelete.setOnClickListener { viewModel.deletelast() }
    }
    /*
    binding.btnResultado.setOnClickListener { presenter.result() }

}

override fun putOperation(operation: String) {
    binding.tvOperation.text = operation
}

override fun putResult(result: String) {
    binding.tvResultNumber.text = result
}*/
}
