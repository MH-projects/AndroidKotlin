/*
 * frgAngelMain.kt
 * Android Kotlin App
 * Created by Angel Morales on 31/08/2022, 11:23:22
 * Copyright (c)  2022 Develop- Mx. All rights reserved.
 */

package com.mh.basickotlin.angel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R

class frgAngelMain : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frg_angel_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnToCalculatorAng).setOnClickListener {
            findNavController().navigate(R.id.frgAngelCalculator)
        }
        view.findViewById<Button>(R.id.btnAngelInformation).setOnClickListener {
            findNavController().navigate(R.id.frgAngelInformation)
        }
        view.findViewById<Button>(R.id.btnAngelRecycle).setOnClickListener {
            findNavController().navigate(R.id.frgAngelRecycleView)
        }
    }
}
