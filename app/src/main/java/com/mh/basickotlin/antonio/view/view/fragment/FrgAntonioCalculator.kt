package com.mh.basickotlin.antonio.view.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.mh.basickotlin.databinding.FrgAntonioCalculatorBinding
import com.mh.basickotlin.antonio.clasesAntonio.Calculadora
import com.mh.basickotlin.antonio.model.Digitos
import com.mh.basickotlin.antonio.model.Operadores
import com.mh.basickotlin.antonio.presenter.AntonioCalculadorContract
import com.mh.basickotlin.antonio.presenter.AntonioCalculadoraPresenter
import com.mh.basickotlin.antonio.viewmodel.CalculadoraViewModel

//class FrgAntonioCalculator : Fragment(),AntonioCalculadorContract.view {
class FrgAntonioCalculator : Fragment(){

    private lateinit var binding: FrgAntonioCalculatorBinding

    private lateinit var presenter: AntonioCalculadorContract.presenter

    val viewModel:CalculadoraViewModel by viewModels()

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

        //presenter = AntonioCalculadoraPresenter(this)

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
            viewModel.autoResult(ischecked)
        }

        viewModel.textResultado.observe(viewLifecycleOwner){resultado->
            binding.tvResult.text=resultado
        }
        viewModel.textOperacion.observe(viewLifecycleOwner){operacion->
            binding.etInsertNum.setText(operacion)
        }

        binding.btnUno.setOnClickListener { viewModel.checkValidDigit(Digitos.uno) }
        binding.btnDos.setOnClickListener { viewModel.checkValidDigit(Digitos.dos) }
        binding.btnTres.setOnClickListener { viewModel.checkValidDigit(Digitos.tres) }
        binding.btnCuatro.setOnClickListener { viewModel.checkValidDigit(Digitos.cuatro)}
        binding.btnCinco.setOnClickListener { viewModel.checkValidDigit(Digitos.cinco) }
        binding.btnSeis.setOnClickListener { viewModel.checkValidDigit(Digitos.seis) }
        binding.btnSiete.setOnClickListener { viewModel.checkValidDigit(Digitos.siete) }
        binding.btnOcho.setOnClickListener { viewModel.checkValidDigit(Digitos.ocho) }
        binding.btnNueve.setOnClickListener { viewModel.checkValidDigit(Digitos.nueve) }
        binding.btnNumCero.setOnClickListener {viewModel.checkValidDigit(Digitos.cero) }

        binding.btnSuma.setOnClickListener { viewModel.checkOperator(Operadores.suma) }
        binding.btnResta.setOnClickListener { viewModel.checkOperator(Operadores.resta) }
        binding.btnMult.setOnClickListener { viewModel.checkOperator(Operadores.mult) }
        binding.btnDiv.setOnClickListener { viewModel.checkOperator(Operadores.div) }

        binding.btnIgual.setOnClickListener { viewModel.result() }
        binding.btnclear.setOnClickListener { viewModel.clear() }
        binding.btnBorrar.setOnClickListener {viewModel.delete()}


    }

    /*override fun setOP(op: String) {
        binding.etInsertNum.text=op
    }

    override fun setResultados(result: String) {
       binding.tvResult.text= result
    }*/


}
