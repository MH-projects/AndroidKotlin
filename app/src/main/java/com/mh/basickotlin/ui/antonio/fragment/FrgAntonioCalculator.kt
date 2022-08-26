package com.mh.basickotlin.ui.antonio.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgAntonioCalculatorBinding
import com.mh.basickotlin.ui.antonio.clasesAntonio.Calculadora

class FrgAntonioCalculator : Fragment() {

    private lateinit var binding: FrgAntonioCalculatorBinding

    // ### OPERADOR ####
    private var firstNumber = ""
    private var secondNumber = ""
    private var operador = ""

    private var isOperador = false
    private var calculadora = Calculadora()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAntonioCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etInsertNum.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // WIP
                if (binding.etInsertNum.text.equals("")) {
                    binding.etInsertNum.setText("")
                }
                if (binding.cbAutoResult.isChecked) {
                    operacion()
                } else {
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }

            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })

        binding.cbAutoResult.setOnClickListener {
            if (binding.cbAutoResult.isChecked) {
                binding.btnIgual.visibility = View.GONE
            } else {
                binding.btnIgual.visibility = View.VISIBLE
            }
        }
        binding.btnUno.setOnClickListener { checkValidDigit("1") }
        binding.btnDos.setOnClickListener { checkValidDigit("2") }
        binding.btnTres.setOnClickListener { checkValidDigit("3") }
        binding.btnCuatro.setOnClickListener { checkValidDigit("4") }
        binding.btnCinco.setOnClickListener { checkValidDigit("5") }
        binding.btnSeis.setOnClickListener { checkValidDigit("6") }
        binding.btnSiete.setOnClickListener { checkValidDigit("7") }
        binding.btnOcho.setOnClickListener { checkValidDigit("8") }
        binding.btnNueve.setOnClickListener { checkValidDigit("9") }
        binding.btnNumCero.setOnClickListener { checkValidDigit("0") }
        binding.btnSuma.setOnClickListener { checkValidDigit("+") }
        binding.btnResta.setOnClickListener { checkValidDigit("-") }
        binding.btnMult.setOnClickListener { checkValidDigit("*") }
        binding.btnDiv.setOnClickListener { checkValidDigit("/") }
        binding.btnIgual.setOnClickListener { checkValidDigit("=") }
        binding.btnclear.setOnClickListener { checkValidDigit("C") }
        binding.btnBorrar.setOnClickListener { checkValidDigit("R") }

        binding.btnIgual.setOnClickListener {
            operacion()

//            binding.tvResult.text = calculator.add(x, y).toString()
//            binding.tvResult.text = "" + calculator.add(x, y)
//            binding.tvResult.setText(calculator.add(x, y))
        }
    }

    private fun checkValidDigit(digit: String) {
        when (digit) {
            "*" -> {
                isOperador = true
                operador = "*"
            }
            "+" -> {
                isOperador = true
                operador = "+"
            }
            "-" -> {
                isOperador = true
                operador = "-"
            }
            "/" -> {
                isOperador = true
                operador = "/"
            }
            // Clear
            "C" -> {
                isOperador = false
                firstNumber = ""
                secondNumber = ""
                binding.tvResult.setText("")
                operador = ""
            }
            // Retroceso
            "R" -> {
                // TODO Contemplar el caso para poner bandera en false
                if (firstNumber.isNotEmpty() && operador.isEmpty() && secondNumber.isEmpty()) {
                    firstNumber = removeLastNchars(firstNumber, 1)
                } else if (firstNumber.isNotEmpty() && operador.isNotEmpty() && secondNumber.isEmpty()) {
                    operador = removeLastNchars(operador, 1)
                } else if (firstNumber.isNotEmpty() && operador.isNotEmpty() && secondNumber.isNotEmpty()) {
                    secondNumber = removeLastNchars(secondNumber, 1)
                } else if (firstNumber.isEmpty() && operador.isEmpty() && secondNumber.isEmpty()) {
                }
                binding.etInsertNum.setText(firstNumber + operador + secondNumber)
                // Main
            }
            "=" -> {
            }
            else -> {
                if (operador.isEmpty()) {
                    // Concatener el digito al primero número
                    if (firstNumber.length < 3) {
                        firstNumber += digit
                    }
                } else {
                    // Concatener el digito al segundo número
                    if (secondNumber.length < 3) {
                        secondNumber += digit
                    }
                }
            }
        }

        Log.i("CALCULADORA", "FirstNumer: $firstNumber")
        Log.i("CALCULADORA", "SecondNumer: $secondNumber")

        binding.etInsertNum.setText("$firstNumber")

        operador?.let { operadorLambda ->
            Log.i("CALCULADORA", "Operation: $firstNumber $operadorLambda $secondNumber")
            binding.etInsertNum.setText("$firstNumber $operadorLambda $secondNumber")
        }
    }

    private fun removeLastNchars(str: String, n: Int): String {
        return if (str.length < n || str.isEmpty()) {
            str
        } else {
            str.substring(0, str.length - n)
        }
    }

    private fun operacion() {
        if (operador == "+") {
            var x = calculadora.convertirStringAInt(firstNumber)
            var y = calculadora.convertirStringAInt(secondNumber)
            binding.tvResult.text = "${calculadora.suma(x, y)}"
        } else if (operador == "-") {
            var x = calculadora.convertirStringAInt(firstNumber)
            var y = calculadora.convertirStringAInt(secondNumber)
            binding.tvResult.text = "${calculadora.resta(x, y)}"
        } else if (operador == "*") {
            var x = calculadora.convertirStringAInt(firstNumber)
            var y = calculadora.convertirStringAInt(secondNumber)
            binding.tvResult.text = "${calculadora.multi(x, y)}"
        } else if (operador == "/") {
            var x = calculadora.convertirStringAInt(firstNumber)
            var y = calculadora.convertirStringAInt(secondNumber)
            binding.tvResult.text = "${calculadora.div(x, y)}"
        }
    }
}
