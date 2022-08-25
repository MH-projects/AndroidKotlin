package com.mh.basickotlin.ui.angel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.databinding.ActAngelMainBinding

class ActAngelMain : AppCompatActivity() {
    private lateinit var binding: ActAngelMainBinding
    private var quanty1 = ""
    private var quanty2 = ""
    private var operator: Char? = null
    private var isOperator = false
    private var Operators = com.mh.basickotlin.ui.angel.Operators()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActAngelMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enlaces
        binding.btnNumCero.setOnClickListener() { validateDigit("0") }
        binding.btnNumOne.setOnClickListener() { validateDigit("1") }
        binding.btnNumTwo.setOnClickListener() { validateDigit("2") }
        binding.btnNumThree.setOnClickListener() { validateDigit("3") }
        binding.btnNumFour.setOnClickListener() { validateDigit("4") }
        binding.btnNumFive.setOnClickListener() { validateDigit("5") }
        binding.btnNumSix.setOnClickListener() { validateDigit("6") }
        binding.btnNumSeven.setOnClickListener() { validateDigit("7") }
        binding.btnNumEight.setOnClickListener() { validateDigit("8") }
        binding.btnNumNine.setOnClickListener() { validateDigit("9") }
        binding.btnMore.setOnClickListener() { validateDigit("+") }
        binding.btnLess.setOnClickListener() { validateDigit("-") }
        binding.btnBy.setOnClickListener() { validateDigit("*") }
        binding.btnBetween.setOnClickListener() { validateDigit("/") }
        binding.btnClean.setOnClickListener() { validateDigit("C") }
        binding.btnDelete.setOnClickListener() { validateDigit("R") }
        binding.btnResultado.setOnClickListener() { validateDigit("R") }
        binding.btnResultado.setOnClickListener {
            var a = Operators.conString(quanty1)
            var b = Operators.conString(quanty2)

            binding.tvResultNumber.text = "${Operators.plus(a, b)}"
        }

        // END

        // TextListener
        binding.etOperation.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val a = Operators.conString(quanty1)
                val b = Operators.conString(quanty2)
                binding.tvResultNumber.text = "${Operators.plus(a,b)}"
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
        // END
    }

    // Funcion de validacion de datos
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
                quanty1 = ""
                quanty2 = ""
                operator = null
                binding.tvResultNumber.text = ""
            }
            "R" -> {
                // por hacer
            }
            "=" -> {
                isOperator = true
            }
            else -> {
                if (isOperator) {
                    // Concatener el digito al segundo número
                    if (quanty2.length < 3) {
                        quanty2 += digit
                    }
                } else {
                    // Concatener el digito al primer número
                    if (quanty1.length < 3) {
                        quanty1 += digit
                    }
                }
            }
        }
        // Mostrar resultado en el ET
        binding.etOperation.setText("$quanty1")
        operator?.let { lambda ->
            binding.etOperation.setText("$quanty1 $lambda $quanty2")
        }
    }
}
