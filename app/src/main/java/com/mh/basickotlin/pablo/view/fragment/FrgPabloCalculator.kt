package com.mh.basickotlin.pablo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgPabloCalculatorBinding
import com.mh.basickotlin.pablo.model.BasicOperations
import com.mh.basickotlin.pablo.model.Number
import com.mh.basickotlin.pablo.presenter.PabloCalculatorPresenter
import com.mh.basickotlin.pablo.presenter.contract.PabloCalculatorContract

class FrgPabloCalculator : Fragment(), PabloCalculatorContract.View {
    private lateinit var binding: FrgPabloCalculatorBinding
    private lateinit var presenter: PabloCalculatorContract.Presenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FrgPabloCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PabloCalculatorPresenter(this)

        binding.cbAutoResult.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) binding.btnEquals.visibility = View.GONE
            else binding.btnEquals.visibility = View.VISIBLE
            presenter.autoResult(isChecked)
        }

        binding.btnNumber0.setOnClickListener { presenter.checkDigit(Number.ZERO) }
        binding.btnNumber1.setOnClickListener { presenter.checkDigit(Number.ONE) }
        binding.btnNumber2.setOnClickListener { presenter.checkDigit(Number.TWO) }
        binding.btnNumber3.setOnClickListener { presenter.checkDigit(Number.THREE) }
        binding.btnNumber4.setOnClickListener { presenter.checkDigit(Number.FOUR) }
        binding.btnNumber5.setOnClickListener { presenter.checkDigit(Number.FIVE) }
        binding.btnNumber6.setOnClickListener { presenter.checkDigit(Number.SIX) }
        binding.btnNumber7.setOnClickListener { presenter.checkDigit(Number.SEVEN) }
        binding.btnNumber8.setOnClickListener { presenter.checkDigit(Number.EIGHT) }
        binding.btnNumber9.setOnClickListener { presenter.checkDigit(Number.NINE) }

        binding.btnAddition.setOnClickListener { presenter.checkOperator(BasicOperations.ADD) }
        binding.btnSubtraction.setOnClickListener { presenter.checkOperator(BasicOperations.SUB) }
        binding.btnMultiplication.setOnClickListener { presenter.checkOperator(BasicOperations.MUL) }
        binding.btnDivision.setOnClickListener { presenter.checkOperator(BasicOperations.DIV) }
        binding.btnClear.setOnClickListener { presenter.clear() }
        binding.btnErase.setOnClickListener { presenter.delete() }
        binding.btnEquals.setOnClickListener { presenter.result() }
    }

    override fun setOperation(operation: String) {
        binding.etInput.setText(operation)
    }

    override fun setResult(result: String) {
        binding.tvResult.text = result
    }

    override fun showToast(text: String) {
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }
}
