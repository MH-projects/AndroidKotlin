package com.mh.basickotlin.juan.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgJuanCalculatorMVPBinding
import com.mh.basickotlin.juan.presenter.JuanCalculatorPresenter
import com.mh.basickotlin.juan.presenter.contract.JuanCalculatorContract

class FrgJuanCalculatorMVP : Fragment(), JuanCalculatorContract.View {
    private lateinit var binding: FrgJuanCalculatorMVPBinding
    private lateinit var presenter: JuanCalculatorContract.Presenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgJuanCalculatorMVPBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = JuanCalculatorPresenter(this)
        binding.btn0.setOnClickListener() { presenter.validateDigit('0') }
        binding.btn1.setOnClickListener() { presenter.validateDigit('1') }
        binding.btn2.setOnClickListener() { presenter.validateDigit('2') }
        binding.btn3.setOnClickListener() { presenter.validateDigit('3') }
        binding.btn4.setOnClickListener() { presenter.validateDigit('4') }
        binding.btn5.setOnClickListener() { presenter.validateDigit('5') }
        binding.btn6.setOnClickListener() { presenter.validateDigit('6') }
        binding.btn7.setOnClickListener() { presenter.validateDigit('7') }
        binding.btn8.setOnClickListener() { presenter.validateDigit('8') }
        binding.btn9.setOnClickListener() { presenter.validateDigit('9') }
        binding.btnmas.setOnClickListener() { presenter.validateOperation('+') }
        binding.btnmenos.setOnClickListener() { presenter.validateOperation('-') }
        binding.btnpor.setOnClickListener() { presenter.validateOperation('x') }
        binding.btndiv.setOnClickListener() { presenter.validateOperation('/') }
        binding.btnres.setOnClickListener() { presenter.getOperation() }
        binding.btndelete.setOnClickListener() { presenter.retroceso() }
        binding.btnclear.setOnClickListener() { presenter.clearAll() }
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnres.visibility = View.INVISIBLE
            } else {
                binding.btnres.visibility = View.VISIBLE
            }
            // presenter.autoResult(isChecked)
        }
        binding.edInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.checkBox.isChecked) {
                    presenter.getOperation()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }

            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })
    }

    override fun setOperation(salida: String) {
        binding.edInput.setText(salida)
    }

    override fun setResult(result: String) {
        binding.tvResult.setText(result)
    }
}
