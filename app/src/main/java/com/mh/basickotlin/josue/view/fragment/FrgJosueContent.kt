package com.mh.basickotlin.josue.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R

class FrgJosueContent : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.frg_josue_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnFrgJosueCalculator).setOnClickListener {
            findNavController().navigate(R.id.frgJosueCalculator)
        }
        view.findViewById<Button>(R.id.btnFrgJosueWelcome).setOnClickListener {
            findNavController().navigate(R.id.frgJosueWelcome)
        }
        view.findViewById<Button>(R.id.btnFrgJosueRecycler).setOnClickListener {
            findNavController().navigate(R.id.frgJosueRecycler)
        }
    }
}
