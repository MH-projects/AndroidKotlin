package com.mh.basickotlin.ui.manuel.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgManuelCalculatorBinding
import com.mh.basickotlin.ui.manuel.model.Digit
import com.mh.basickotlin.ui.manuel.model.Operator
import com.mh.basickotlin.ui.manuel.presenter.ManuelCalculatorPresenter
import com.mh.basickotlin.ui.manuel.presenter.contract.ManuelCalculatorContract

class FrgManuelCalculator : Fragment(), ManuelCalculatorContract.View {

    private lateinit var binding: FrgManuelCalculatorBinding

    private lateinit var presenter: ManuelCalculatorContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgManuelCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ManuelCalculatorPresenter(this)

        binding.cbAutoResult.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                binding.btnEquals.visibility = View.INVISIBLE
            } else {
                binding.btnEquals.visibility = View.VISIBLE
            }

            presenter.autoResult(isChecked)
        }

        binding.btn0.setOnClickListener { presenter.checkDigit(Digit.ZERO) }
        binding.btn1.setOnClickListener { presenter.checkDigit(Digit.ONE) }
        binding.btn2.setOnClickListener { presenter.checkDigit(Digit.TWO) }
        binding.btn3.setOnClickListener { presenter.checkDigit(Digit.THREE) }
        binding.btn4.setOnClickListener { presenter.checkDigit(Digit.FOUR) }
        binding.btn5.setOnClickListener { presenter.checkDigit(Digit.FIVE) }
        binding.btn6.setOnClickListener { presenter.checkDigit(Digit.SIX) }
        binding.btn7.setOnClickListener { presenter.checkDigit(Digit.SEVEN) }
        binding.btn8.setOnClickListener { presenter.checkDigit(Digit.EIGHT) }
        binding.btn9.setOnClickListener { presenter.checkDigit(Digit.NINE) }

        binding.btnAdd.setOnClickListener { presenter.checkOperator(Operator.ADD) }
        binding.btnRes.setOnClickListener { presenter.checkOperator(Operator.SUB) }
        binding.btnMul.setOnClickListener { presenter.checkOperator(Operator.MUL) }
        binding.btnDiv.setOnClickListener { presenter.checkOperator(Operator.DIV) }

        binding.btnClear.setOnClickListener { presenter.clear() }
        binding.btnEquals.setOnClickListener { presenter.result() }
        binding.btnDel.setOnClickListener { presenter.delete() }
    }

    override fun setOperation(operation: String) {
        binding.tvOperation.text = operation
    }

    override fun setResult(result: String) {
        binding.tvResult.text = result
    }
}
