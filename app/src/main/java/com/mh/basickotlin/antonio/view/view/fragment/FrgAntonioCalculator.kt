package com.mh.basickotlin.antonio.view.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgAntonioCalculatorBinding
import com.mh.basickotlin.antonio.clasesAntonio.Calculadora
import com.mh.basickotlin.antonio.model.Digitos
import com.mh.basickotlin.antonio.model.Operadores
import com.mh.basickotlin.antonio.presenter.AntonioCalculadorContract
import com.mh.basickotlin.antonio.presenter.AntonioCalculadoraPresenter

class FrgAntonioCalculator : Fragment(),AntonioCalculadorContract.view {

    private lateinit var binding: FrgAntonioCalculatorBinding

    private lateinit var presenter: AntonioCalculadorContract.presenter

    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAntonioCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = AntonioCalculadoraPresenter(this)

       /* binding.etInsertNum.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // WIP
                if (binding.etInsertNum.text.equals("")) {
                    binding.etInsertNum.setText("")
                }
                if (binding.cbAutoResult.isChecked) {
                    operacion()
                } else {
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }

            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })*/

        binding.cbAutoResult.setOnCheckedChangeListener { _, ischecked ->
            if (ischecked) {
                binding.btnIgual.visibility = View.GONE
            } else {
                binding.btnIgual.visibility = View.VISIBLE
            }
            presenter.autoResult(ischecked)
        }
        binding.btnUno.setOnClickListener { presenter.checkValidDigit(Digitos.uno) }
        binding.btnDos.setOnClickListener { presenter.checkValidDigit(Digitos.dos) }
        binding.btnTres.setOnClickListener { presenter.checkValidDigit(Digitos.tres) }
        binding.btnCuatro.setOnClickListener { presenter.checkValidDigit(Digitos.cuatro)}
        binding.btnCinco.setOnClickListener { presenter.checkValidDigit(Digitos.cinco) }
        binding.btnSeis.setOnClickListener { presenter.checkValidDigit(Digitos.seis) }
        binding.btnSiete.setOnClickListener { presenter.checkValidDigit(Digitos.siete) }
        binding.btnOcho.setOnClickListener { presenter.checkValidDigit(Digitos.ocho) }
        binding.btnNueve.setOnClickListener { presenter.checkValidDigit(Digitos.nueve) }
        binding.btnNumCero.setOnClickListener {presenter.checkValidDigit(Digitos.cero) }

        binding.btnSuma.setOnClickListener { presenter.checkOperator(Operadores.suma) }
        binding.btnResta.setOnClickListener { presenter.checkOperator(Operadores.resta) }
        binding.btnMult.setOnClickListener { presenter.checkOperator(Operadores.mult) }
        binding.btnDiv.setOnClickListener { presenter.checkOperator(Operadores.div) }

        binding.btnIgual.setOnClickListener { presenter.result() }
        binding.btnclear.setOnClickListener { presenter.clear() }
        binding.btnBorrar.setOnClickListener {presenter.delete()}


    }

    override fun setOP(op: String) {
        binding.etInsertNum.text=op
    }

    override fun setResultados(result: String) {
       binding.tvResult.text= result
    }


}
