package com.mh.basickotlin.ui.manuel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R

class FrgDevs : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frg_devs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnManuel).setOnClickListener {
            findNavController().navigate(R.id.toFrgManuelCalculator)
        }
        view.findViewById<Button>(R.id.btnAntonio).setOnClickListener {
            findNavController().navigate(R.id.toFrgAntonioContent)
        }
        view.findViewById<Button>(R.id.btnAngel).setOnClickListener {
            findNavController().navigate(R.id.tofrgAngelMain)
        }
    }
}
