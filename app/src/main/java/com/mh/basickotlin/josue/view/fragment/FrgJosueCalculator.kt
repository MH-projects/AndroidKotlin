package com.mh.basickotlin.josue.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgJosueCalculatorBinding
import com.mh.basickotlin.josue.model.Digito
import com.mh.basickotlin.josue.model.Operator
import com.mh.basickotlin.josue.presenter.JosueCalculatorPresenter
import com.mh.basickotlin.josue.presenter.contract.JosueCalculatorContract

class FrgJosueCalculator : Fragment(), JosueCalculatorContract.View {

    private lateinit var binding: FrgJosueCalculatorBinding
    private lateinit var presenter: JosueCalculatorContract.MediatorModelAndView

    /*private var oneNumber = ""
    private var twoNumber = ""
    private var operator = ""
    private var isOperator = false*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgJosueCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = JosueCalculatorPresenter(this)

        binding.swAutoResult.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.btnResult.visibility = View.INVISIBLE
            } else {
                binding.btnResult.visibility = View.VISIBLE
            }
            presenter.resultAuto(isChecked)
        }

        binding.btnZero.setOnClickListener() { presenter.checkNums(Digito.CERO) }
        binding.btnOne.setOnClickListener() { presenter.checkNums(Digito.UNO) }
        binding.btnTwo.setOnClickListener() { presenter.checkNums(Digito.DOS) }
        binding.btnThree.setOnClickListener() { presenter.checkNums(Digito.TRES) }
        binding.btnFour.setOnClickListener() { presenter.checkNums(Digito.CUATRO) }
        binding.btnFive.setOnClickListener() { presenter.checkNums(Digito.CINCO) }
        binding.btnSix.setOnClickListener() { presenter.checkNums(Digito.SEIS) }
        binding.btnSeven.setOnClickListener() { presenter.checkNums(Digito.SIETE) }
        binding.btnEight.setOnClickListener() { presenter.checkNums(Digito.OCHO) }
        binding.btnNine.setOnClickListener() { presenter.checkNums(Digito.NUEVE) }
        // OPERADORES
        binding.btnSum.setOnClickListener() { presenter.checkOper(Operator.SUM) }
        binding.btnRest.setOnClickListener() { presenter.checkOper(Operator.REST) }
        binding.btnMult.setOnClickListener() { presenter.checkOper(Operator.MULT) }
        binding.btnDiv.setOnClickListener() { presenter.checkOper(Operator.DIV) }
        // ACTIONS
        binding.btnClean.setOnClickListener() { presenter.clean() }
        binding.btnRemove.setOnClickListener() { presenter.errase() }
        binding.btnResult.setOnClickListener() { presenter.resultado() }
    }

    override fun showOperation(operation: String) {
        binding.etInputedit.setText(operation)
    }

    override fun showResult(result: String) {
        binding.tvResultado.text = result
    }
}
