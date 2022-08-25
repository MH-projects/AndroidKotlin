package com.mh.basickotlin.ui.josue

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.mh.basickotlin.databinding.ActJosueMainBinding

class ActJosueMain : AppCompatActivity() {

    private lateinit var binding: ActJosueMainBinding
    private var oneNumber = ""
    private var twoNumber = ""
    private var operator: Char ? = null
    private var isOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActJosueMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // switch
        /*binding.swAutoResult.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.btnResult.visibility = View.INVISIBLE
                autoResult()
            } else {
                binding.btnResult.visibility = View.VISIBLE
                binding.btnResult.setOnClickListener() {
                    var numUno = Operation().convertStringToInt(oneNumber)
                    var numDos = Operation().convertStringToInt(twoNumber)
                    if (operator == '+') {
                        binding.tvResultado.text = Operation().suma(numUno, numDos).toString()
                    }
                    if (operator == '-') {
                        binding.tvResultado.text = Operation().resta(numUno, numDos).toString()
                    }
                    if (operator == '*') {
                        binding.tvResultado.text = Operation().multi(numUno, numDos).toString()
                    }
                    if (operator == '/') {
                        binding.tvResultado.text = Operation().div(numUno, numDos).toString()
                    }
                }
            }
        }*/

        binding.etInputedit.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.swAutoResult.isChecked) {
                    binding.btnResult.visibility = View.GONE
                    var numUno = Operation().convertStringToInt(oneNumber)
                    var numDos = Operation().convertStringToInt(twoNumber)
                    if (operator == '+') {
                        binding.tvResultado.text = Operation().suma(numUno, numDos).toString()
                    }
                    if (operator == '-') {
                        binding.tvResultado.text = Operation().resta(numUno, numDos).toString()
                    }
                    if (operator == '*') {
                        binding.tvResultado.text = Operation().multi(numUno, numDos).toString()
                    }
                    if (operator == '/') {
                        binding.tvResultado.text = Operation().div(numUno, numDos).toString()
                    }
                } else {
                    binding.btnResult.visibility = View.VISIBLE
                    binding.btnResult.setOnClickListener() {
                        var numUno = Operation().convertStringToInt(oneNumber)
                        var numDos = Operation().convertStringToInt(twoNumber)
                        if (operator == '+') {
                            binding.tvResultado.text = Operation().suma(numUno, numDos).toString()
                        }
                        if (operator == '-') {
                            binding.tvResultado.text = Operation().resta(numUno, numDos).toString()
                        }
                        if (operator == '*') {
                            binding.tvResultado.text = Operation().multi(numUno, numDos).toString()
                        }
                        if (operator == '/') {
                            binding.tvResultado.text = Operation().div(numUno, numDos).toString()
                        }
                    }
                }
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
        binding.btnFour.setOnClickListener() { validateDigit("4") }
        binding.btnFive.setOnClickListener() { validateDigit("5") }
        binding.btnSix.setOnClickListener() { validateDigit("6") }
        binding.btnSeven.setOnClickListener() { validateDigit("7") }
        binding.btnEight.setOnClickListener() { validateDigit("8") }
        binding.btnNine.setOnClickListener() { validateDigit("9") }
        binding.btnSum.setOnClickListener() { validateDigit("+") }
        binding.btnRest.setOnClickListener() { validateDigit("-") }
        binding.btnMult.setOnClickListener() { validateDigit("*") }
        binding.btnDiv.setOnClickListener() { validateDigit("/") }
        binding.btnClean.setOnClickListener() { validateDigit("C") }
        binding.btnRemove.setOnClickListener() { validateDigit("R") }
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
