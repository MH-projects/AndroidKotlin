/*
 * FrgManuelPresentation.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 01/09/2022, 13:04:04
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgManuelPresentationBinding
import com.mh.basickotlin.manuel.presentation.model.PresentationData
import com.mh.basickotlin.manuel.presentation.presenter.DatePickerAlert
import com.mh.basickotlin.manuel.presentation.presenter.PresentationContract
import com.mh.basickotlin.manuel.presentation.presenter.PresentationPresenter
import com.mh.custom_alert.CustomAlert
import com.mh.custom_alert.Theme
import com.mh.custom_alert.Type

class FrgManuelPresentation : Fragment(), PresentationContract.View {

    private lateinit var binding: FrgManuelPresentationBinding

    private lateinit var presenter: PresentationContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgManuelPresentationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        presenter = PresentationPresenter(requireContext(), this@FrgManuelPresentation)
        presenter.getInfo()

        binding.etState.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_mh_option,
                resources.getStringArray(R.array.mh_states)
            )
        )

        binding.etGender.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_mh_option,
                listOf("Masculino", "Femenino")
            )
        )

        binding.etDateNac.setOnClickListener {
            DatePickerAlert(requireContext(), this@FrgManuelPresentation).show()
        }

        binding.btnSave.setOnClickListener {
            clearErrors()
            presenter.saveData(buildData())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.mh_menu_presentation, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionDelete -> {
                println("MenuItem: Delete")
            }

            R.id.actionEdit -> {
                println("MenuItem: Edit")
            }

            R.id.actionShare -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"

                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Compartir info")
                sharingIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    """
                        Nombre: Manuel Hidalgo
                        Fecha de Nacimiento: 10/10/1995
                        Edad: 27
                        Nùmero: 656541851469
                        Estado de nacimiento: CDMX
                        Sexo: Masculino
                    """
                )
                startActivity(Intent.createChooser(sharingIntent, "ShareTitle"))
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun buildData(): PresentationData {
        return PresentationData(
            name = binding.etName.text.toString(),
            surname = binding.etSurname.text.toString(),
            phone = binding.etNumber.text.toString(),
            birthday = binding.etDateNac.text.toString(),
            age = if (binding.etAge.text.toString().isEmpty()) 0 else binding.etAge.text.toString()
                .toInt(),
            state = binding.etState.text.toString(),
            gender = binding.etGender.text.toString()
        )
    }

    private fun clearErrors() {
        binding.inputName.error = null
        binding.inputDateNac.error = null
        binding.inputNumber.error = null
    }

    override fun showErrorName() {
        binding.inputName.error = "Nombre obligatorio"
        binding.inputName.requestFocus()
    }

    override fun showErrorBirthday() {
        binding.inputDateNac.error = "Fecha de nacimiento obligatoria."
        binding.inputDateNac.requestFocus()
    }

    override fun showErrorNumber(error: String) {
        binding.inputNumber.error = error
        binding.inputNumber.requestFocus()
    }

    override fun showResult(status: String) {
//        val alert = AlertDialog.Builder(requireContext())
//        alert.setTitle("Exitoso")
//        alert.setMessage(status)
//        alert.setIcon(R.drawable.ic_mh_check)
//        alert.setCancelable(false)
//
//        alert.setNegativeButton("Cancelar") { dialog, _ ->
//            dialog.dismiss()
//        }
//
//        alert.setPositiveButton("Aceptar") { dialog, _ ->
//            dialog.cancel()
//        }
//
//        alert.show()

        val customAlert = CustomAlert(requireActivity(), Theme.SYSTEM)
        customAlert.setType(Type.SUCCESS)
        customAlert.setTitle("Success!")
        customAlert.setMessage(status)
        customAlert.setPositiveText("Ok") {
            showInfo(
                PresentationData(
                    name = "",
                    surname = "",
                    phone = "",
                    birthday = "",
                    age = 0,
                    state = "",
                    gender = ""
                )
            )

            customAlert.dismiss()
        }
        customAlert.show()
    }

    override fun showInfo(data: PresentationData) {
        binding.etName.setText(data.name)
        binding.etSurname.setText(data.surname)
        if (data.birthday.isEmpty()) {
            binding.etDateNac.setText("dd/mm/yyyy")
        } else {
            binding.etDateNac.setText(data.birthday)
        }
        if (data.age != 0) {
            binding.etAge.setText(data.age.toString())
        } else {
            binding.etAge.setText("")
        }
        binding.etNumber.setText(data.phone)
        binding.etState.setText(data.state)
        binding.etGender.setText(data.gender)
    }

    override fun showBirthday(birthday: String) {
        binding.etDateNac.setText(birthday)
        presenter.calculateAge(birthday)
    }

    override fun showAge(age: Int) {
        binding.etAge.setText("$age")
    }
}
