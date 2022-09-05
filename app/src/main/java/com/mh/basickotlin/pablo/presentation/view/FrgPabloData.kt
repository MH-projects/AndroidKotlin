/*
 * FrgPabloData.kt
 * Android Kotlin App"
 * Created by Pablo Amaya on 01/09/2022, 14:52:25
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.pablo.presentation.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgPabloDataBinding
import com.mh.basickotlin.pablo.presentation.model.PresentationModel
import com.mh.basickotlin.pablo.presentation.model.TypeError
import com.mh.basickotlin.pablo.presentation.presenter.DatePickerAlert
import com.mh.basickotlin.pablo.presentation.presenter.PabloPresentationPresenter
import com.mh.basickotlin.pablo.presentation.presenter.contract.PabloPresentationContract

class FrgPabloData : Fragment(), PabloPresentationContract.View {
    private lateinit var binding: FrgPabloDataBinding
    private lateinit var presenter: PabloPresentationPresenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgPabloDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        presenter = PabloPresentationPresenter(requireContext(), this)
        presenter.getData()
        binding.btnSave.setOnClickListener {
            clearError()
            presenter.saveData(
                PresentationModel(
                    name = binding.etName.text.toString(),
                    surName = binding.etSurName.text.toString(),
                    birthday = binding.etBirthday.text.toString(),
                    age = binding.etAge.text.toString(),
                    phone = binding.etPhone.text.toString(),
                    state = binding.etState.text.toString(),
                    gender = binding.etSex.text.toString()
                )
            )
        }

        binding.etState.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_pablo_option,
                resources.getStringArray(R.array.pa_states)
            )
        )

        binding.etSex.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_pablo_option,
                listOf("Mascuino", "Femenino", "Tortillera", "Gatorade", "Transformer")
            )
        )

        binding.etBirthday.setOnClickListener {
            DatePickerAlert(requireContext(), this).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.pa_menu_presentation, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionDelate -> {}
            R.id.actionEdit -> {}
            R.id.actionShare -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Compartir info")
                sharingIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    """
                    Nombre:
                    Fecha de Nacimiento:
                    Edad:
                    """.trimIndent()
                )
                startActivity(Intent.createChooser(sharingIntent, "SharedTitle"))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showError(typeError: TypeError) {
        when (typeError) {
            TypeError.NAME -> {
                binding.inputName.error = typeError.error
            }
            TypeError.BIRTHDAY -> {
                binding.inputBirthday.error = typeError.error
            }
            else -> {
                binding.inputPhone.error = typeError.error
            }
        }
    }

    override fun showSaveData(messange: String) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Exitoso")
        alert.setMessage(messange)
        alert.setIcon(R.drawable.ic_pa_thumb)
        alert.setCancelable(false)

        // alert.setNegativeButton("Cancelar") { dialog, _ ->
        //     dialog.cancel()
        // }
        alert.setPositiveButton("Aceptar") { dialog, _ ->

            dialog.cancel()
        }
        // alert.setNeutralButton("Cancelar") { dialog, _ ->
        //    dialog.cancel()
        // }
        alert.show()
    }

    override fun setSaveData(presentation: PresentationModel) {
        if (presentation.name.isNotEmpty() || presentation.name.isNotBlank()) {
            binding.etName.setText(presentation.name)
            binding.etSurName.setText(presentation.surName)
            binding.etBirthday.setText(presentation.birthday)
            binding.etAge.setText(presentation.age)
            binding.etPhone.setText(presentation.phone)
            binding.etState.setText(presentation.state)
            binding.etSex.setText(presentation.gender)
            binding.etName.isEnabled = false
            binding.etSurName.isEnabled = false
            binding.etBirthday.isEnabled = false
            binding.etAge.isEnabled = false
            binding.etPhone.isEnabled = false
            binding.etState.isEnabled = false
            binding.etSex.isEnabled = false
            binding.btnSave.visibility = View.GONE
        }
    }

    override fun showBirthday(birthday: String) {
        binding.etBirthday.setText(birthday)
        presenter.getAge(binding.etBirthday.text.toString())
    }

    override fun showAge(age: String) {
        binding.etAge.setText(age)
    }

    private fun clearError() {
        binding.inputName.error = null
        binding.inputBirthday.error = null
        binding.inputPhone.error = null
    }
}
