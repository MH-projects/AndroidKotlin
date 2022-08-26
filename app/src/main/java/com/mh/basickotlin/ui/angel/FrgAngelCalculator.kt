package com.mh.basickotlin.ui.angel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgAngelCalculatorBinding

class FrgAngelCalculator : Fragment() {

    private lateinit var binding: FrgAngelCalculatorBinding
    private var quanty1 = ""
    private var quanty2 = ""
    private var operator = ""
    private var isOperator = false
    private var operationComplete = String
    private var Operators = Operators()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgAngelCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        binding.btnDelete.setOnClickListener() {
            binding.tvResultNumber.text = null
            binding.etOperation.setText("")
        }
        binding.btnResultado.setOnClickListener() { validateDigit("=") }
        binding.cbAuResult.setOnClickListener {
            if (binding.cbAuResult.isChecked) binding.btnResultado.visibility = View.GONE
            else binding.btnResultado.visibility = View.VISIBLE
        }
        // TextListener
        binding.etOperation.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.cbAuResult.isChecked) {
                    val a = Operators.conString(quanty1)
                    val b = Operators.conString(quanty2)
                    if (operator == "+") {
                        binding.tvResultNumber.text =
                            "${Operators.plus(a, b)}"
                    }
                    if (operator == "-") {
                        binding.tvResultNumber.text =
                            "${Operators.less(a, b)}"
                    }
                    if (operator == "*") {
                        binding.tvResultNumber.text =
                            "${Operators.by(a, b)}"
                    }
                    if (operator == "/") {
                        if (quanty1.toInt() == 0 || quanty2.toInt() == 0 || quanty1.isEmpty() || quanty2.isEmpty()) {
                            Toast.makeText(
                                requireContext(),
                                "No puedes ocupar ceros en la division",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            binding.tvResultNumber.text =
                                "${Operators.split(a, b)}"
                        }
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
        // END

        binding.btnResultado.setOnClickListener {
            var a = Operators.conString(quanty1)
            var b = Operators.conString(quanty2)

            if (operator == "+") {
                binding.tvResultNumber.text = "${Operators.plus(a, b)}"
            }
            if (operator == "-") {
                binding.tvResultNumber.text = "${Operators.less(a, b)}"
            }
            if (operator == "*") {
                binding.tvResultNumber.text = "${Operators.by(a, b)}"
            }
            if (operator == "/") {
                if (quanty1.toInt() == 0 || quanty2.toInt() == 0 || quanty1.isEmpty() || quanty2.isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "No puedes ocupar ceros en la division",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    binding.tvResultNumber.text = "${Operators.split(a, b)}"
                }
            }
        }
        // END
    }

    // Funcion de validacion de datos
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
                quanty1 = ""
                quanty2 = ""
                binding.tvResultNumber.text = null
                binding.etOperation.setText("")
            }
            "R" -> {
                deleteLast()
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
            operationComplete.equals("$quanty1,$lambda,$quanty2").toString()
        }
    }

    private fun deleteLast() {
        if (quanty1.isNotEmpty() && operator.isNullOrEmpty() && quanty2.isEmpty()) {
            quanty1 = removeLast(quanty1, 1)
        } else if (quanty1.isNotEmpty() && operator.isNotEmpty() && quanty2.isEmpty()) {
            operator = removeLast(operator, 1)
        } else if (quanty1.isNotEmpty() && operator.isNotEmpty() && quanty2.isNotEmpty()) {
            quanty2 = removeLast(quanty2, 1)
        }
        binding.etOperation.setText(quanty1 + operator + quanty2)
    }

    private fun removeLast(str: String, n: Int): String {
        return if (str.length < n || str.isEmpty()) {
            str
        } else str.substring(0, str.length - n)
    }
}
