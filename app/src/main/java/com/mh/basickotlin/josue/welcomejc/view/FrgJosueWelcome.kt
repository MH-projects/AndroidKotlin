/*
 * FrgJosueWelcome.kt
 * Android Kotlin App
 * Created by Josue Isaias on 01/09/2022, 15:48:33
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.welcomejc.view

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgJosueWelcomeBinding
import com.mh.basickotlin.josue.welcomejc.model.JosueWelcomeForm
import com.mh.basickotlin.josue.welcomejc.presenter.DatePikerAlert
import com.mh.basickotlin.josue.welcomejc.presenter.JosueWelcomePresenter
import com.mh.basickotlin.josue.welcomejc.presenter.contract.JosueWelcomeContract

class FrgJosueWelcome : Fragment(), JosueWelcomeContract.InterfaceWelcomeView {

    private lateinit var binding: FrgJosueWelcomeBinding
    private lateinit var presenter: JosueWelcomePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgJosueWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        presenter = JosueWelcomePresenter(this)

        binding.etFecNac.setOnClickListener {
            DatePikerAlert(requireContext()).show()
        }
        binding.etState.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_jc_option,
                resources.getStringArray(R.array.jc_states)
            )
        )
        binding.etGender.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_jc_option,
                listOf("Masculino", "Feminine", "Les", "Gay")
            )
        )

        var dataUser = JosueWelcomeForm(
            binding.etName.text.toString(),
            binding.etSurName.text.toString(),
            binding.etNum.text.toString()
        )

        binding.btnView.setOnClickListener {
            Toast.makeText(requireContext(), "Data", Toast.LENGTH_SHORT).show()
            presenter.guardarInfo(dataUser)
        }

        /*override fun mostrarInfo(status: String) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Exitoso")
        alert.setMessage(status)
        alert.setIcon(R.drawable.png_jc_mambe)
        alert.setCancelable(false)

        alert.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }

        alert.setPositiveButton("Aceptar") { dialog, _ ->
            dialog.cancel()
        }
        alert.show()
    }*/
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.jc_menu_welcome, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionDelete -> {
                presenter.deleteData()
            }
            R.id.actionEdit -> {
                presenter.suma(2, 2)
            }
            R.id.actionShare -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun mostrarInfo(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun mostrarResultado(res: Int) {
        Toast.makeText(requireContext(), "$res", Toast.LENGTH_SHORT).show()
    }
}
