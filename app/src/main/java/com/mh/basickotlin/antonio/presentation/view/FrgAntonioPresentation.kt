/*
 * FrgAntonioPresentation.kt
 * Android Kotlin App
 * Created by Antonio Barrientos Rios on 01/09/2022, 15:10:56
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.antonio.presentation.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mh.basickotlin.R
import com.mh.basickotlin.antonio.presentation.model.dataPresenter
import com.mh.basickotlin.antonio.presentation.presenter.AntonioPresentationPresenter
import com.mh.basickotlin.antonio.presentation.presenter.DataPikerAlert
import com.mh.basickotlin.antonio.presentation.presenter.PresentadorContract
import com.mh.basickotlin.databinding.FrgAntonioCalculadoraBinding
import com.mh.basickotlin.databinding.FrgAntonioCalculatorBinding
import com.mh.basickotlin.databinding.FrgAntonioPresentationBinding

class FrgAntonioPresentation : Fragment(),PresentadorContract.View {

    lateinit var binding: FrgAntonioPresentationBinding

    //se agrega el presenter
    lateinit var presenter:AntonioPresentationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAntonioPresentationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setHasOptionsMenu(true)
        
        //inicializacion del presenter
        presenter = AntonioPresentationPresenter(this,requireContext())
        presenter.getData()

        binding.btnAntonioSave.setOnClickListener {

            //SharePreference
            //se coloca el presenter para pasar la funcion que tendra los datos del tipo de la funcion
            //para dar los datos que tendremos que almacenar
            presenter.saveData(dataPresenter(
                binding.etAntonioName.text.toString(),
                binding.etAntoniorSurName.text.toString(),
                binding.etAntoniorNumber.text.toString()
            ))
            showResult("Guardado")
        }
        binding.etAntoniorAge.setOnClickListener {
            DataPikerAlert(requireContext()).show(binding.etAntoniorAge)
        }
        binding.etAntoniorState.setAdapter(
            ArrayAdapter(
                requireContext(),R.layout.itme_ab_state_option,resources.getStringArray(R.array.ab_states)
            )
        )
        /*val listSex= listOf("Masculino","Femenino","Lesbiana","Gay","Trans")
        binding.etAntoniorSex.setAdapter(
            ArrayAdapter(
                requireContext(),R.layout.itme_ab_state_option,listSex)
            )
        )*/
    }
//menu

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        
        inflater.inflate(R.menu.ab_menu_presenter,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.actionDelete->{
                Toast.makeText(requireContext(), "elimina", Toast.LENGTH_SHORT).show()
            }
            R.id.actionEdit->{
                Toast.makeText(requireContext(),    "edit", Toast.LENGTH_SHORT).show()
            }
            R.id.actionCompartir->{
                //TODO compartir datos de la aplicacion
                val sharinIntent=Intent(Intent.ACTION_SEND)
                sharinIntent.type="text/plain"
                sharinIntent.putExtra(Intent.EXTRA_SUBJECT,"compartir info")
                sharinIntent.putExtra(Intent.EXTRA_TEXT,"""
                    nombre de mi app
                """.trimIndent())
                startActivity(Intent.createChooser(sharinIntent,"CompartirTitle"))
                Toast.makeText(requireContext(), "compartir", Toast.LENGTH_SHORT).show()
            }


        }

        return super.onOptionsItemSelected(item)
    }
//menu

    override fun showData() {
        Toast.makeText(requireContext(), "Datos Guardados Correcta Mente", Toast.LENGTH_SHORT).show()
    }

    override fun setData() {
        TODO("Not yet implemented")
    }

    override fun loadData(dataPresenter: dataPresenter) {
        binding.etAntonioName.setText(dataPresenter.name)
        binding.etAntoniorSurName.setText(dataPresenter.surname)
        binding.etAntoniorNumber.setText(dataPresenter.phone)
    }

    override fun error() {
        binding.etAntonioName.error="Requiere un nombre"
        binding.etAntonioName.requestFocus()
    }

    override fun showResult(status: String) {
        val alert =AlertDialog.Builder(requireContext())
        alert.setTitle("Exitoso")
        alert.setMessage(status)//status es un dato de show resultk
        alert.setIcon(R.drawable.ic_airplane)
        alert.setCancelable(false)
        alert.setNegativeButton("Cancelar"){dialog,_ ->
            dialog.dismiss()
        }
        alert.setNegativeButton("Aceptar"){dialog,_->
            dialog.cancel()
        }
        alert.show()
    }

    override fun showAge(birthday: String) {
        binding.etAntoniorAge.setText(birthday)
        presenter.setAge(birthday)
    }

}