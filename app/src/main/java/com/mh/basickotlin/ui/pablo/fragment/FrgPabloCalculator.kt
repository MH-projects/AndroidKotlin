package com.mh.basickotlin.ui.pablo.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgPabloCalculatorBinding
import com.mh.basickotlin.ui.pablo.CalculatorPablo

class FrgPabloCalculator : Fragment() {
    private lateinit var binding: FrgPabloCalculatorBinding
    private var numberOne = ""
    private var numberTwo = ""
    private var specialCharacter = ""
    private val calculator = CalculatorPablo()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FrgPabloCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cbAutoResult.setOnClickListener {
            if (binding.cbAutoResult.isChecked) {
                binding.btnEquals.visibility = View.GONE
            } else binding.btnEquals.visibility = View.VISIBLE
        }

        binding.etInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.cbAutoResult.isChecked) {
                    val x = calculator.convertStringToInt(numberOne)
                    val y = calculator.convertStringToInt(numberTwo)
                    binding.tvResult.text = "${calculator.plus(x, y)}"
                    doOperation(x, y)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }

            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })
        binding.btnNumber0.setOnClickListener(getString(R.string.zero_number))
        binding.btnNumber1.setOnClickListener(getString(R.string.one_number))
        binding.btnNumber2.setOnClickListener(getString(R.string.two_number))
        binding.btnNumber3.setOnClickListener(getString(R.string.three_number))
        binding.btnNumber4.setOnClickListener(getString(R.string.four_number))
        binding.btnNumber5.setOnClickListener(getString(R.string.five_number))
        binding.btnNumber6.setOnClickListener(getString(R.string.six_number))
        binding.btnNumber7.setOnClickListener(getString(R.string.seven_number))
        binding.btnNumber8.setOnClickListener(getString(R.string.eight_number))
        binding.btnNumber9.setOnClickListener(getString(R.string.nine_number))
        binding.btnAddition.setOnClickListener(getString(R.string.operation_addition))
        binding.btnSubtraction.setOnClickListener(getString(R.string.operation_subtraction))
        binding.btnMultiplication.setOnClickListener(getString(R.string.operation_multiplication))
        binding.btnDivision.setOnClickListener(getString(R.string.operation_division))
        binding.btnClear.setOnClickListener(getString(R.string.clear))
        binding.btnErase.setOnClickListener(getString(R.string.delete))
        binding.btnEquals.setOnClickListener {
            val x = calculator.convertStringToInt(numberOne)
            val y = calculator.convertStringToInt(numberTwo)
            doOperation(x, y)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun Button.setOnClickListener(number: String) {
        setOnClickListener {
            when (number) {
                "+", "/", "-", "x" -> {
                    if (numberOne.isEmpty()) showToast(
                        "No se pueden ingresar operaciones al principio",
                        context
                    )
                    else {
                        specialCharacter = number
                    }
                }
                "C" -> {
                    numberOne = ""
                    numberTwo = ""
                    specialCharacter = ""
                    binding.etInput.setText("")
                    binding.tvResult.text = ""
                }
                "D" -> {
                    deleteCharacter()
                }
                else -> {
                    if (specialCharacter.isEmpty()) {
                        if (numberOne.length < 3) {
                            numberOne += number
                        } else showToast("No se pueden ingresar mas de 3 numeros", context)
                    } else if (numberTwo.length < 3) {
                        numberTwo += number
                    } else showToast("No se pueden ingresar mas de 3 numeros", context)
                }
            }
            binding.etInput.setText(numberOne + specialCharacter + numberTwo)
        }
    }

    private fun showToast(text: String, context: Context) {
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    @SuppressLint("SetTextI18n")
    private fun deleteCharacter() {
        if (numberOne.isNotEmpty() && specialCharacter.isEmpty() && numberTwo.isEmpty()) {
            numberOne = removeLastChars(numberOne, 1)
        } else if (numberOne.isNotEmpty() && specialCharacter.isNotEmpty() && numberTwo.isEmpty()) {
            specialCharacter = removeLastChars(specialCharacter, 1)
        } else if (numberOne.isNotEmpty() && specialCharacter.isNotEmpty() && numberTwo.isNotEmpty()) {
            numberTwo = removeLastChars(numberTwo, 1)
        }
        binding.etInput.setText(numberOne + specialCharacter + numberTwo)
    }

    private fun doOperation(x: Int, y: Int) {
        if (numberOne.isNotEmpty() && specialCharacter.isNotEmpty() && numberTwo.isNotEmpty()) {
            when (specialCharacter) {
                "+" -> {
                    binding.tvResult.text = "${calculator.plus(x, y)}"
                }
                "-" -> {
                    binding.tvResult.text = "${calculator.minus(x, y)}"
                }
                "x" -> {
                    binding.tvResult.text = "${calculator.times(x, y)}"
                }
                "/" -> {
                    binding.tvResult.text =
                        if (calculator.div(x, y) == -1) "Error" else "${calculator.div(x, y)}"
                }
            }
        }
    }

    private fun removeLastChars(str: String, n: Int): String {
        return if (str.length < n || str.isEmpty()) {
            str
        } else str.substring(0, str.length - n)
    }
}
