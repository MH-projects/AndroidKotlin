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
        binding.btnres.setOnClickListener() { validateCaracter('s') }
    }

    private fun validateCaracter(caracter: Char) {
        if (aux.length < 3) {
            cant1 = aux
        } else {
            cant2 = aux
        }

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
            '0' -> {
                aux += caracter
            }
            '1' -> {
                aux += caracter
            }
            '2' -> {
                aux += caracter
            }
            '3' -> {
                aux += caracter
            }
            '4' -> {
                aux += caracter
            }
            '5' -> {
                aux += caracter
            }
            '6' -> {
                aux += caracter
            }
            '7' -> {
                aux += caracter
            }
            '8' -> {
                aux += caracter
            }
            '9' -> {
                aux += caracter
            }
            'C' -> {
                cant1 = ""
                cant2 = ""
            }
            'r' -> {}
            '=' -> {
                var auxc1 = cant1.toInt()
                var auxc2 = cant2.toInt()
                when (operation) {
                    '+' -> {
                        res = auxc1 + auxc2
                        binding.tvResult.text = "$res"
                    }
                    '-' -> {
                        res = auxc1 - auxc2
                        binding.tvResult.text = "$res"
                    }
                    'x' -> {
                        res = auxc1 * auxc2
                        binding.tvResult.text = "$res"
                    }
                    '/' -> {
                        res = auxc1 / auxc2
                        binding.tvResult.text = "$res"
                    }
                    else -> {}
                }
            }
            else -> {}
        }
        binding.edInput.setText("$cant1 $operation $cant2")
    }
}
