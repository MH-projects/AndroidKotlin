package com.mh.basickotlin.ui.juan.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.databinding.ActJuanMainBinding

class ActJuanMain : AppCompatActivity() {
    private lateinit var binding: ActJuanMainBinding
    private var cant1 = ""
    private var cant2 = ""
    private var operation = ' '
    private var aux = ""
    private var res = 0
    private var calculator = Calculator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActJuanMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.btnclear.setOnClickListener() { validateCaracter('c') }
        binding.btndelete.setOnClickListener() { validateCaracter('r') }
        binding.btnres.setOnClickListener() { validateCaracter('=') }

        binding.btnres.setOnClickListener() {
            var auxc1 = cant1.toInt()
            var auxc2 = cant2.toInt()
            when (operation) {
                '+' -> {
                    res = calculator.suma(auxc1, auxc2)
                }
                '-' -> {
                    res = calculator.resta(auxc1, auxc2)
                }
                'x' -> {
                    res = calculator.mult(auxc1, auxc2)
                }
                '/' -> {
                    res = calculator.div(auxc1, auxc2)
                }
            }
            binding.tvResult.text = "$res"
        }
        /*
        binding.edInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var auxc1 = cant1.toInt()
                var auxc2 = cant2.toInt()
                when (operation) {
                    '+' -> {
                        res = calculator.suma(auxc1, auxc2)
                    }
                    '-' -> {
                        res = calculator.resta(auxc1, auxc2)
                    }
                    'x' -> {
                        res = calculator.mult(auxc1, auxc2)
                    }
                    '/' -> {
                        res = calculator.div(auxc1, auxc2)
                    }
                }
                binding.tvResult.text = "$res"
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }

            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })*/
    }

    private fun validateCaracter(caracter: Char) {
        when (caracter) {
            '+' -> {
                operation = '+'
                aux = ""
            }
            '-' -> {
                operation = '-'
                aux = ""
            }
            'x' -> {
                operation = 'x'
                aux = ""
            }
            '/' -> {
                operation = '/'
                aux = ""
            }
            'c' -> {
                cant1 = ""
                cant2 = ""
                aux = ""
                binding.edInput.setText("")
            }
            else -> {
                if (operation != ' ') {
                    if (cant1.length < 3) {
                        cant1 += caracter
                        binding.edInput.setText("$cant1")
                    } else {
                    }
                } else {
                    binding.edInput.setText("$cant1 $operation ")
                    if (cant2.length < 3) {
                        cant2 += caracter
                        binding.edInput.setText("$cant1 $operation $cant2")
                    } else {
                    }
                }
            }
        }
    }
}
