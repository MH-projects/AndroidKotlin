package com.mh.basickotlin.ui.Antonio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.widget.addTextChangedListener
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.ActAntonioMainBinding

class ActAntonioMain : AppCompatActivity() {
    //bindind tomara el nombre del layout de la actividad con formato camel case
    private lateinit var binding: ActAntonioMainBinding


    private var totalDigits = ""
    private var digits = ""
    private var temp = ""
    private var operacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //sustituimos el setcontentview de la siguiente forma
        binding= ActAntonioMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //accedemos a los componentes de la vista de la siguiente forma
        binding.btnIgual.setOnClickListener {
            if(operacion.equals("Suma")){
                if (temp.equals("") && digits.equals("")){
                    Toast.makeText(this@ActAntonioMain, "error", Toast.LENGTH_SHORT).show()
                    binding.etInsertNum.setText("")
                    temp=""
                    digits=""
                    binding.tvResult.setText("")
                }else{
                    binding.tvResult.setText(suma(temp,digits))
                }
            }else if(operacion.equals("Resta")){
                if (temp.equals("") && digits.equals("")) {
                    Toast.makeText(this@ActAntonioMain, "error", Toast.LENGTH_SHORT).show()
                    binding.etInsertNum.setText("")
                    temp = ""
                    digits = ""
                    binding.tvResult.setText("")
                }else{
                    binding.tvResult.setText(resta(temp,digits))
                }
            }else if(operacion.equals("Multi")){
                if (temp.equals("") && digits.equals("")){
                    Toast.makeText(this@ActAntonioMain, "error", Toast.LENGTH_SHORT).show()
                    binding.etInsertNum.setText("")
                    temp=""
                    digits=""
                    binding.tvResult.setText("")
                }else{
                    binding.tvResult.setText(multi(temp,digits))
                }
            }else if(operacion.equals("Div")){
                if (temp.equals("") && digits.equals("")) {
                    Toast.makeText(this@ActAntonioMain, "error", Toast.LENGTH_SHORT).show()
                    binding.etInsertNum.setText("")
                    temp = ""
                    digits = ""
                    binding.tvResult.setText("")
                }else{
                    binding.tvResult.setText(div(temp,digits))
                }
            }
        }
        binding.btnSuma.setOnClickListener {
            binding.etInsertNum.setText(totalDigits + "+")
            temp = digits
            digits = ""
            binding.etInsertNum.setText("0")
            operacion="Suma"
        }

        binding.btnResta.setOnClickListener {
            binding.etInsertNum.setText(totalDigits + "-")
            temp = digits
            digits = ""
            binding.etInsertNum.setText("0")
            operacion="Resta"
        }
        binding.btnMult.setOnClickListener {
            binding.etInsertNum.setText(totalDigits + "*")
            temp = digits
            digits = ""
            binding.etInsertNum.setText("0")
            operacion="Multi"
        }
        binding.btnDiv.setOnClickListener {
            binding.etInsertNum.setText(totalDigits + "/")
            temp = digits
            digits = ""
            binding.etInsertNum.setText("0")
            operacion="Div"
        }
        binding.btnUno.setOnClickListener {
            digits += "1"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnDos.setOnClickListener {
            digits += "2"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnTres.setOnClickListener {
            digits += "3"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnCuatro.setOnClickListener {
            digits += "4"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnCinco.setOnClickListener {
            digits += "5"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnSeis.setOnClickListener {
            digits += "6"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnSiete.setOnClickListener {
            digits += "7"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnOcho.setOnClickListener {
            digits += "8"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnNueve.setOnClickListener {
            digits += "9"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnNumCero.setOnClickListener {
            digits += "0"
            totalDigits = digits
            binding.etInsertNum.setText(digits)
            binding.etInsertNum.setText(totalDigits)
        }
        binding.btnclear.setOnClickListener {
            binding.etInsertNum.setText("")
            temp=""
            totalDigits=""
            digits=""
            binding.tvResult.setText("")
        }

        binding.btnBorrar.setOnClickListener {
            if (totalDigits.length>0){
                digits.substring(0, digits.length - 2)
            }else{
                Toast.makeText(this@ActAntonioMain, "no hay digitos", Toast.LENGTH_SHORT).show()
            }
        }
        binding.cbAutoResult.setOnClickListener {
            if (binding.cbAutoResult.isChecked){
                //agregar el auto resultado
                binding.btnIgual.visibility=View.GONE

                binding.etInsertNum.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        TODO("Not yet implemented")
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        TODO("Not yet implemented")
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })

            }else{
                binding.btnIgual.visibility= View.VISIBLE
            }
        }


    }



    fun sumaA(a: String,b: String){
        var su= a.toInt() + b.toInt()
        binding.tvResult.setText(su.toString())
    }

    fun suma(a:String, b:String): String{
            var suma = a.toInt() + b.toInt()
            digits = suma.toString()
            return suma.toString()
    }

    fun resta(a:String, b:String): String{
        var resta = a.toInt() - b.toInt()
        digits = resta.toString()
        return resta.toString()
    }
    fun multi(a:String, b:String): String{
        var suma = a.toInt() * b.toInt()
        digits = suma.toString()
        return suma.toString()
    }

    fun div(a:String, b:String): String{
        var resta = a.toInt() / b.toInt()
        digits = resta.toString()
        return resta.toString()
    }
}