/*
 * FrgJosuePresentation.kt
 * Android Kotlin App
 * Created by Josue Isaias on 02/09/2022, 17:08:36
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.josue.pckpresentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.josue.pckpresentation.model.UsrDataForm
import com.mh.basickotlin.josue.pckpresentation.presenter.IPresenterContract
import com.mh.basickotlin.josue.pckpresentation.presenter.PresenterImpl

class FrgJosuePresentation : Fragment(), IPresenterContract.View {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_josue_presentation, container, false)
    }

    private lateinit var presenter: PresenterImpl

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var data = UsrDataForm("Josue", "Cazare", "22222")
        presenter.saveDataUsr(data)
    }

    override fun showAlert() {
        TODO("Not yet implemented")
    }
}
