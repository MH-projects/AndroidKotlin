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
            }
            '=' -> {
                var auxc1 = cant1.toInt()
                var auxc2 = cant2.toInt()
                when (operation) {
                    '+' -> {
                        res = auxc1 + auxc2
                    }
                    '-' -> {
                        res = auxc1 - auxc2
                    }
                    'x' -> {
                        res = auxc1 * auxc2
                    }
                    '/' -> {
                        res = auxc1 / auxc2
                    }
                    // else -> {}
                }
                binding.tvResult.text = "$res"
                println("************************************$res")
            }
            else -> {
                aux += caracter
                if (aux.length < 3) {
                    cant1 = aux
                } else {
                    cant2 = aux
                }
            }
        }
        binding.edInput.setText("$cant1 $operation $cant2")
    }
}
