package com.mh.basickotlin.ui.josue

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.mh.basickotlin.databinding.ActJosueMainBinding

class ActJosueMain : AppCompatActivity() {

    private lateinit var binding: ActJosueMainBinding
    private var oneNumber = ""
    private var twoNumber = ""
    private var operator: Char ? = null
    private var resSuma = ""
    private var resRest = ""
    private var resMult = ""
    private var isOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActJosueMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etInputedit.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        binding.btnZero.setOnClickListener() { validateDigit("0") }
        binding.btnOne.setOnClickListener() { validateDigit("1") }
        binding.btnTwo.setOnClickListener() { validateDigit("2") }
        binding.btnThree.setOnClickListener() { validateDigit("3") }
        binding.btnSum.setOnClickListener() { validateDigit("+") }
        binding.btnRest.setOnClickListener() { validateDigit("-") }
        binding.btnMult.setOnClickListener() { validateDigit("*") }
        binding.btnDiv.setOnClickListener() { validateDigit("/") }
        binding.btnClean.setOnClickListener() { validateDigit("C") }
        binding.btnResult.setOnClickListener() { validateDigit("=") }
    }

    private fun validateDigit(digit: String) {
        when (digit) {
            "*" -> {
                isOperator = true
                operator = '*'
            }
            "+" -> {
                isOperator = true
                operator = '+'
            }
            "-" -> {
                isOperator = true
                operator = '-'
            }
            "/" -> {
                isOperator = true
                operator = '/'
            }
            "C" -> {
                isOperator = false
                oneNumber = ""
                twoNumber = ""
                operator = null
                binding.tvResultado.text = ""
            }
            "R" -> {
                // por hacer
            }
            "=" -> {
                isOperator = true
                if (digit == "+") {
                    resSuma = (oneNumber.toInt() + twoNumber.toInt()).toString()
                    binding.tvResultado.text = resSuma
                }
                if (digit == "-") {
                    resRest = (oneNumber.toInt() - twoNumber.toInt()).toString()
                    binding.tvResultado.text = resRest
                }
            }
            else -> {
                if (isOperator) {
                    // Concatener el digito al segundo número
                    if (twoNumber.length < 3) {
                        twoNumber += digit
                    }
                } else {
                    // Concatener el digito al primer número
                    if (oneNumber.length < 3) {
                        oneNumber += digit
                    }
                }
            }
        }
        // Imprimir resultado en pantalla
        binding.etInputedit.setText("$oneNumber")
        operator?.let { lambda ->
            binding.etInputedit.setText("$oneNumber $lambda $twoNumber")
        }
    }
}
