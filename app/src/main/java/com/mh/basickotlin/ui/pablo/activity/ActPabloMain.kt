package com.mh.basickotlin.ui.pablo.activity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.ActPabloMainBinding
import com.mh.basickotlin.ui.pablo.CalculatorPablo

class ActPabloMain : AppCompatActivity() {
    private lateinit var binding: ActPabloMainBinding
    private var numberOne = ""
    private var numberTwo = ""
    private var specialCharacter = ""
    private val calculator = CalculatorPablo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActPabloMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cbAutoResult.setOnClickListener {
            if (binding.cbAutoResult.isChecked) {
                binding.btnEquals.visibility = View.GONE
            } else binding.btnEquals.visibility = View.VISIBLE
        }

        binding.etInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.cbAutoResult.isChecked) {
                    var x = calculator.convertStringToInt(numberOne)
                    var y = calculator.convertStringToInt(numberTwo)
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
            var x = calculator.convertStringToInt(numberOne)
            var y = calculator.convertStringToInt(numberTwo)
            doOperation(x, y)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun Button.setOnClickListener(number: String) {
        setOnClickListener {
            when (number) {
                "+", "/", "-", "x" -> {
                    if (numberOne.isEmpty()) Toast.makeText(
                        context,
                        "No se pueden ingresar operaciones al principio",
                        Toast.LENGTH_SHORT
                    ).show()
                    else {
                        specialCharacter = number
                        binding.etInput.setText(numberOne + specialCharacter)
                    }
                }
                "C" -> {
                    numberOne = ""
                    numberTwo = ""
                    specialCharacter = ""
                    binding.etInput.setText("")
                }
                "D" -> {
                }
                "=" -> {
                }
                else -> {
                    if (specialCharacter.isEmpty()) {
                        if (numberOne.length < 3) {
                            numberOne += number
                            binding.etInput.setText(numberOne)
                        } else showToast("No se pueden ingresar mas de 3 numeros", context)
                    } else if (numberTwo.length < 3) {
                        numberTwo += number
                        binding.etInput.setText(numberOne + specialCharacter + numberTwo)
                    } else showToast("No se pueden ingresar mas de 3 numeros", context)
                }
            }
        }
    }

    private fun showToast(text: String, context: Context) {
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
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
                    binding.tvResult.text = "${calculator.div(x, y)}"
                }
            }
        }
    }
}
