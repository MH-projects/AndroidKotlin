package com.mh.basickotlin.ui.josue

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgJosueCalculatorBinding

class FrgJosueCalculator : Fragment() {

    private lateinit var binding: FrgJosueCalculatorBinding
    private var oneNumber = ""
    private var twoNumber = ""
    private var operator = ""
    private var isOperator = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgJosueCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swAutoResult.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.btnResult.visibility = View.INVISIBLE
            } else {
                binding.btnResult.visibility = View.VISIBLE
            }
        }

        binding.etInputedit.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var numUno = Operation().convertStringToInt(oneNumber)
                var numDos = Operation().convertStringToInt(twoNumber)

                if (binding.swAutoResult.isChecked) {
                    // binding.btnResult.visibility = View.INVISIBLE
                    if (operator == "+") {
                        binding.tvResultado.text = Operation().suma(numUno, numDos).toString()
                    }
                    if (operator == "-") {
                        binding.tvResultado.text = Operation().resta(numUno, numDos).toString()
                    }
                    if (operator == "*") {
                        binding.tvResultado.text = Operation().multi(numUno, numDos).toString()
                    }
                    if (operator == "/" && oneNumber.isNotEmpty() && twoNumber.isNotEmpty()) {
                        var numUno = Operation().convertStringToInt(oneNumber)
                        var numDos = Operation().convertStringToInt(twoNumber)
                        binding.tvResultado.text = Operation().div(numUno, numDos).toString()
                    }
                } else {
                    // binding.btnResult.visibility = View.VISIBLE
                    binding.btnResult.setOnClickListener() {
                        if (operator == "+") {
                            binding.tvResultado.text = Operation().suma(numUno, numDos).toString()
                        }
                        if (operator == "-") {
                            binding.tvResultado.text = Operation().resta(numUno, numDos).toString()
                        }
                        if (operator == "*") {
                            binding.tvResultado.text = Operation().multi(numUno, numDos).toString()
                        }
                        if (operator == "/") {
                            var numUno = Operation().convertStringToInt(oneNumber)
                            var numDos = Operation().convertStringToInt(twoNumber)
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
        binding.btnRemove.setOnClickListener() {
            var sentences = binding.etInputedit.text
            var aux = sentences.dropLast(1)
            binding.etInputedit.setText("$aux")
        }
    }
    private fun validateDigit(digit: String) {
        when (digit) {
            "*" -> {
                isOperator = true
                operator = "*"
            }
            "+" -> {
                isOperator = true
                operator = "+"
            }
            "-" -> {
                isOperator = true
                operator = "-"
            }
            "/" -> {
                isOperator = true
                operator = "/"
            }
            "C" -> {
                isOperator = false
                oneNumber = ""
                twoNumber = ""
                operator = ""
                binding.tvResultado.text = ""
            }
            "D" -> {
                isOperator = false
                erraseChar()
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
            binding.etInputedit.setText("$oneNumber$lambda$twoNumber")
        }
    }

    private fun removeChar(character: String, position: Int): String {
        return if (character.length < position || character.isEmpty()) {
            character
        } else character.substring(0, character.length - position)
    }

    private fun erraseChar() {
        if (oneNumber.isNotEmpty() && isOperator == false && twoNumber.isEmpty()) {
            oneNumber = removeChar(oneNumber, 1)
        }
        if (oneNumber.isNotEmpty() && isOperator == false && twoNumber.isNotEmpty()) {
            twoNumber = removeChar(twoNumber, 1)
        }
        if (oneNumber.isNotEmpty() && isOperator == true && twoNumber.isNotEmpty()) {
            operator = removeChar(operator, 1)
        }
        binding.etInputedit.setText(oneNumber + operator + twoNumber)
    }
}

