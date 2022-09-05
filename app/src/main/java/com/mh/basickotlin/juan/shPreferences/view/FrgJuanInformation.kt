/*
 * FrgJuanInformation.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 01/09/2022, 15:21:24
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.shPreferences.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgJuanInformationBinding
import com.mh.basickotlin.juan.shPreferences.model.Formulario
import com.mh.basickotlin.juan.shPreferences.model.ShPref
import com.mh.basickotlin.juan.shPreferences.presenter.DatePickerAlert
import com.mh.basickotlin.juan.shPreferences.presenter.JuanShPreferencesPresenter
import com.mh.basickotlin.juan.shPreferences.presenter.contract.JuanShPreferenceContract

class FrgJuanInformation : Fragment(), JuanShPreferenceContract.View {
    private lateinit var binding: FrgJuanInformationBinding
    private lateinit var presenter: JuanShPreferenceContract.Presenter
    private var birthday = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgJuanInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val shp = ShPref(view.context)
        presenter = JuanShPreferencesPresenter(this, shp)
        presenter.restaurar()

        binding.btnSave.setOnClickListener() {
            presenter.SaveData(rellenar())
        }
        binding.etDate.setOnClickListener {
            DatePickerAlert(requireContext(), presenter).show()
        }
        binding.etDate.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // presenter.setAge(binding.etDate.text)
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // WIP
            }
            override fun afterTextChanged(s: Editable) {
                // WIP
            }
        })
        /*Mediante xml*/
        binding.etState.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_juan_option,
                resources.getStringArray(R.array.jp_states)
            )
        )
        /*mediante codigo*/
        var listGender = listOf("Hetero", "Femenino", "Trans", "Pansexual", "Bi")
        binding.etSex.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_juan_option,
                listGender
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.jp_menu_presentation, menu)
    }

    override fun showAge(age: Int) {
        binding.etAge.setText("$age")
    }

    override fun birthday(res: String) {
        birthday = res
        binding.etDate.setText("$res")
    }

    override fun Resultado(res: String) {
        Toast.makeText(context, res, Toast.LENGTH_LONG).show()
    }

    fun rellenar(): Formulario {
        return Formulario(
            name = binding.etName.text.toString(),
            surname = binding.etSurname.text.toString(),
            date = binding.etDate.text.toString(),
            age = binding.etAge.text.toString().toInt(),
            phone = binding.etNum.text.toString().toInt(),
            city = binding.etState.text.toString(),
            genre = binding.etSex.text.toString()
        )
    }

    override fun ShowResult() {
        var alert = AlertDialog.Builder(requireContext())
        alert.setTitle(("exitoso"))
        // alert.setMessage(status)
        // alert.setIcon(R.drawable.ic)
        alert.setCancelable(false)
        alert.setNegativeButton("cancelar") { dialo, _ ->
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionDelete -> {
                binding.etName.setText("")
                binding.etSurname.setText("")
                binding.etDate.setText("")
                binding.etAge.setText("")
                binding.etNum.setText("")
                binding.etState.setText("")
                binding.etSex.setText("")
            }
            R.id.actionEdit -> {
                binding.etName.requestFocus()
            }
            R.id.actionShare -> {
                val sharedIntent = Intent(Intent.ACTION_SEND)
                sharedIntent.type = "text/plain"
                sharedIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    """
                        information
                    """.trimIndent()
                )
                startActivity(Intent.createChooser(sharedIntent, "ShareTitle"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun setName(name: String) {
        binding.etName.setText(name)
    }
    override fun setSurname(name: String) {
        binding.etSurname.setText(name)
    }
    override fun setAge(name: Int) {
        binding.etAge.setText("$name")
    }
    override fun setPhone(name: Int) {
        binding.etNum.setText("$name")
    }
    override fun setCity(name: String) {
        binding.etState.setText(name)
    }
    override fun setGenre(name: String) {
        binding.etSex.setText(name)
    }
    override fun setBirthday(name: String) {
        binding.etDate.setText(name)
    }

}
