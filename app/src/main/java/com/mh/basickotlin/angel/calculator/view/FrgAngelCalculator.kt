/*
 * FrgAngelCalculator.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 11:19:17
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.calculator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgAngelCalculatorBinding
import com.mh.basickotlin.angel.calculator.model.Numbers
import com.mh.basickotlin.angel.calculator.model.Operators
import com.mh.basickotlin.angel.calculator.presenter.AngelCalcContract
import com.mh.basickotlin.angel.calculator.presenter.AngelCalculatorPresenter

class FrgAngelCalculator : Fragment(), AngelCalcContract.View {
    private lateinit var binding: FrgAngelCalculatorBinding

    private lateinit var presenter: AngelCalcContract.presenter

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
        presenter = AngelCalculatorPresenter(this)

        // Manera de saber si el checkblox esta seleccionado y el guin bajo funciona para un parametro sin usar
        binding.cbAuResult.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnResultado.visibility = View.INVISIBLE
            } else {
                binding.btnResultado.visibility = View.VISIBLE
            }
            presenter.autoResult(isChecked)
        }

        binding.btnNumCero.setOnClickListener() { presenter.checkDigit(Numbers.Zero) }
        binding.btnNumOne.setOnClickListener() { presenter.checkDigit(Numbers.One) }
        binding.btnNumTwo.setOnClickListener() { presenter.checkDigit(Numbers.Two) }
        binding.btnNumThree.setOnClickListener() { presenter.checkDigit(Numbers.Three) }
        binding.btnNumFour.setOnClickListener() { presenter.checkDigit(Numbers.Four) }
        binding.btnNumFive.setOnClickListener() { presenter.checkDigit(Numbers.Five) }
        binding.btnNumSix.setOnClickListener() { presenter.checkDigit(Numbers.Six) }
        binding.btnNumSeven.setOnClickListener() { presenter.checkDigit(Numbers.Seven) }
        binding.btnNumEight.setOnClickListener() { presenter.checkDigit(Numbers.Eight) }
        binding.btnNumNine.setOnClickListener() { presenter.checkDigit(Numbers.Nine) }

        binding.btnMore.setOnClickListener { presenter.checkOperator(Operators.Plus) }
        binding.btnLess.setOnClickListener { presenter.checkOperator(Operators.Less) }
        binding.btnBy.setOnClickListener { presenter.checkOperator(Operators.By) }
        binding.btnBetween.setOnClickListener { presenter.checkOperator(Operators.Div) }

        binding.btnClean.setOnClickListener { presenter.clear() }
        binding.btnResultado.setOnClickListener { presenter.result() }
        binding.btnDelete.setOnClickListener { presenter.deletelast() }
    }

    override fun putOperation(operation: String) {
        binding.tvOperation.text = operation
    }

    override fun putResult(result: String) {
        binding.tvResultNumber.text = result
    }
}
