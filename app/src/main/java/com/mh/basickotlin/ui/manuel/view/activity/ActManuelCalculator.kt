package com.mh.basickotlin.ui.manuel.view.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.databinding.ActManuelCalculatorBinding
import com.mh.basickotlin.ui.manuel.Calculator

class ActManuelCalculator : AppCompatActivity() {

    private lateinit var binding: ActManuelCalculatorBinding

    // ### OPERADOR ####
    private var firstNumber = ""
    private var secondNumber = ""
    private var operador: Char? = null

    private var isOperador = false

    private var calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActManuelCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // WIP

                val x = calculator.convertStringToInt(firstNumber)
                val y = calculator.convertStringToInt(secondNumber)

                binding.tvResult.text = "${calculator.suma(x, y)}"
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }

            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })

        binding.btnOne.setOnClickListener { checkValidDigit("1") }
        binding.btnTwo.setOnClickListener { checkValidDigit("2") }
        binding.btnThree.setOnClickListener { checkValidDigit("3") }
        binding.btnAdd.setOnClickListener { checkValidDigit("+") }
        binding.btnClear.setOnClickListener { checkValidDigit("C") }

        binding.btnResult.setOnClickListener {
            var x = calculator.convertStringToInt(firstNumber)
            var y = calculator.convertStringToInt(secondNumber)

            binding.tvResult.text = "${calculator.suma(x, y)}"
//            binding.tvResult.text = calculator.add(x, y).toString()
//            binding.tvResult.text = "" + calculator.add(x, y)
//            binding.tvResult.setText(calculator.add(x, y))
        }
    }

    private fun checkValidDigit(digit: String) {
        when (digit) {
            "*" -> {
                isOperador = true
            }
            "+" -> {
                isOperador = true
                operador = '+'
            }
            "-" -> {
                isOperador = true
            }
            "/" -> {
                isOperador = true
            }
            // Clear
            "C" -> {
                isOperador = false
                firstNumber = ""
                secondNumber = ""
                operador = null
            }
            // Retroceso
            "R" -> {
                // TODO Contemplar el caso para poner bandera en false
            }
            "=" -> {
            }
            else -> {
                if (isOperador) {
                    // Concatener el digito al segundo número
                    if (secondNumber.length < 3) {
                        secondNumber += digit
                    }
                } else {
                    // Concatener el digito al primer número
                    if (firstNumber.length < 3) {
                        firstNumber += digit
                    }
                }
            }
        }

        Log.i("CALCULADORA", "FirstNumer: $firstNumber")
        Log.i("CALCULADORA", "SecondNumer: $secondNumber")

        binding.etInput.setText("$firstNumber")

        operador?.let { operadorLambda ->
            Log.i("CALCULADORA", "Operation: $firstNumber $operadorLambda $secondNumber")
            binding.etInput.setText("$firstNumber $operadorLambda $secondNumber")
        }
    }
}
