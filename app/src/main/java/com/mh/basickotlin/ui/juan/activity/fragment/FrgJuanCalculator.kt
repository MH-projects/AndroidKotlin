package com.mh.basickotlin.ui.juan.activity.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgJuanCalculatorBinding
import com.mh.basickotlin.ui.juan.activity.Calculator

class FrgJuanCalculator : Fragment() {
    private lateinit var binding: FrgJuanCalculatorBinding
    private var cant1 = ""
    private var cant2 = ""
    private var operation = ' '
    private var res = 0
    private var calculator = Calculator()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgJuanCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn0.setOnClickListener() { validateCaracter('0') }
        binding.btn1.setOnClickListener() { validateCaracter('1') }
        binding.btn2.setOnClickListener() { validateCaracter('2') }
        binding.btn3.setOnClickListener() { validateCaracter('3') }
        binding.btn4.setOnClickListener() { validateCaracter('4') }
        binding.btn5.setOnClickListener() { validateCaracter('5') }
        binding.btn6.setOnClickListener() { validateCaracter('6') }
        binding.btn7.setOnClickListener() { validateCaracter('7') }
        binding.btn8.setOnClickListener() { validateCaracter('8') }
        binding.btn9.setOnClickListener() { validateCaracter('9') }
        binding.btnmas.setOnClickListener() { validateCaracter('+') }
        binding.btnmenos.setOnClickListener() { validateCaracter('-') }
        binding.btnpor.setOnClickListener() { validateCaracter('x') }
        binding.btndiv.setOnClickListener() { validateCaracter('/') }
        binding.btnres.setOnClickListener() { validateCaracter('=') }

        binding.btndelete.setOnClickListener() {
            var aux = binding.edInput.text.dropLast(1)
            binding.edInput.setText(" ")
            binding.edInput.setText(aux)

            if (cant2.isEmpty()) {
                operation = ' '
                res = 0
                if (!cant1.isEmpty()) {
                    var canaux1 = cant1.dropLast(1)
                }
            } else {
                var canaux2 = cant2.dropLast(1)
                cant2 = canaux2
            }
            if (aux.isEmpty()) {
                res = 0
                cant1 = ""
                binding.edInput.setText(" ")
            }

            var auxv1 = if (cant1.isEmpty()) 0 else cant1.toInt()
            var auxv2 = if (cant2.isEmpty()) 0 else cant2.toInt()
            when (operation) {
                '+' -> {
                    res = calculator.suma(auxv1, auxv2)
                }
                '-' -> {
                    res = calculator.resta(auxv1, auxv2)
                }
                'x' -> {
                    res = calculator.mult(auxv1, auxv2)
                }
                '/' -> {
                    res = calculator.div(auxv1, auxv2)
                }
            }
            binding.tvResult.text = "$res"
        }
        binding.btnclear.setOnClickListener() {
            cant1 = ""
            cant2 = ""
            operation = ' '
            binding.edInput.setText("")
            binding.tvResult.setText("0")
            res = 0
        }
        binding.checkBox.setOnClickListener {
            if (binding.checkBox.isChecked) {
                binding.btnres.visibility = View.GONE
            } else binding.btnres.visibility = View.VISIBLE
        }
        binding.btnres.setOnClickListener() {
            var auxv1 = if (cant1.isEmpty()) 0 else cant1.toInt()
            var auxv2 = if (cant2.isEmpty()) 0 else cant2.toInt()
            when (operation) {
                '+' -> {
                    res = calculator.suma(auxv1, auxv2)
                }
                '-' -> {
                    res = calculator.resta(auxv1, auxv2)
                }
                'x' -> {
                    res = calculator.mult(auxv1, auxv2)
                }
                '/' -> {
                    res = calculator.div(auxv1, auxv2)
                }
            }
            binding.tvResult.text = "$res"
        }

        binding.edInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var auxv1 = if (cant1.isEmpty()) 0 else cant1.toInt()
                var auxv2 = if (cant2.isEmpty()) 0 else cant2.toInt()
                when (operation) {
                    '+' -> {
                        res = calculator.suma(auxv1, auxv2)
                    }
                    '-' -> {
                        res = calculator.resta(auxv1, auxv2)
                    }
                    'x' -> {
                        res = calculator.mult(auxv1, auxv2)
                    }
                    '/' -> {
                        res = calculator.div(auxv1, auxv2)
                    }
                }
                if (binding.checkBox.isChecked) { binding.tvResult.text = "$res" }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }

            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })
    }

    private fun validateCaracter(caracter: Char) {
        when (caracter) {
            '+' -> {
                operation = '+'
            }
            '-' -> {
                operation = '-'
            }
            'x' -> {
                operation = 'x'
            }
            '/' -> {
                operation = '/'
            }

            else -> {
                // binding.edInput.setText("$cant1 $operation $cant2")
                if (operation == ' ') {
                    if (cant1.length < 3) {
                        cant1 += caracter
                    } else {
                    }
                } else {
                    if (cant2.length < 3) {
                        cant2 += caracter
                        // binding.edInput.setText("$cant1 $operation $cant2")
                    } else {
                    }
                }
            }
        }
        binding.edInput.setText("$cant1")

        operation?.let { operadorLambda ->
            Log.i("CALCULADORA", "Operation: $cant1 $operadorLambda $cant2")
            binding.edInput.setText("$cant1$operadorLambda$cant2")
        }
    }
}
