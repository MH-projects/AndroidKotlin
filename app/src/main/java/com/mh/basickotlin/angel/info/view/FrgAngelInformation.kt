/*
 * FrgAngelInformation.kt
 * Android Kotlin App
 * Created by Angel Morales on 01/09/2022, 14:54:35
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel.info.view

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.view.* // ktlint-disable no-wildcard-imports
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.angel.info.model.AngelFormModel
import com.mh.basickotlin.angel.info.presenter.AngelFormContract
import com.mh.basickotlin.angel.info.presenter.AngelFormPresenter
import com.mh.basickotlin.databinding.FrgAngelInformationBinding

class FrgAngelInformation : Fragment(), AngelFormContract.View {

    private lateinit var binding: FrgAngelInformationBinding
    private lateinit var presenter: AngelFormPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAngelInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Para inflar el menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.am_menu_info, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionamDelete -> {
                println("Menu Item: Delete")
            }
            R.id.actionamEdit -> {
                println("Menu Item: Edit")
            }

            R.id.actionamShare -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"

                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "compartir Info")
                sharingIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    // TODO Poner la informacion de los campos ya sea por medio del binding o del sp
                    """Informacion""".trimIndent()
                )
                startActivity(Intent.createChooser(sharingIntent, "SharingTitle"))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = AngelFormPresenter(requireContext(), this)
        presenter.returnData()
        setHasOptionsMenu(true)
        binding.btnAngelSave.setOnClickListener() {
            presenter.saveData(
                AngelFormModel(
                    binding.etAngelName.text.toString(),
                    binding.etAngelSurname.text.toString(),
                    binding.etAngelNumber.text.toString()
                )
            )
        }
        binding.etAngelBirthday.setOnClickListener() {
        }
        binding.etAngelPlace.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_am_option,
                resources.getStringArray(R.array.am_estates)
            )
        )

        val listGender = listOf("Male", "Female", "Lesbin", "Trans", "Gey", "Tractocamion")
        binding.etAngelGender.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_am_option,
                listGender
            )
        )
    }

    override fun showData(data: String) {
        Toast.makeText(requireContext(), "Informacion Guardada", Toast.LENGTH_LONG).show()
    }

    override fun loadData(data: AngelFormModel) {
        binding.etAngelName.setText(data.NAME)
        binding.etAngelSurname.setText(data.SURNAME)
        binding.etAngelNumber.setText(data.NUMERO)
    }
}
