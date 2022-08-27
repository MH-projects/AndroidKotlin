package com.mh.basickotlin.ui.juan.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
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
            var auxv1 = cant1.toInt()
            var auxv2 = cant2.toInt()
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
        /*binding.checkBox.setOnClickListener {
            if (binding.checkBox.isChecked) {
                println("activo **************************")
            }
        }*/

        binding.edInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var auxv1 = if (cant1.isEmpty()) 0 else cant1.toInt()
                var auxv2 = if (cant1.isEmpty()) 0 else cant1.toInt()

                binding.tvResult.text = calculator.suma(auxv1, auxv2).toString()
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
            'c' -> {
                cant1 = ""
                cant2 = ""
                operation = ' '
                binding.edInput.setText("")
                binding.tvResult.setText("")
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
            binding.edInput.setText("$cant1 $operadorLambda $cant2")
        }
    }
}
