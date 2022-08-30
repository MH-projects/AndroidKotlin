package com.mh.basickotlin.antonio.view.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mh.basickotlin.R

class FrgAntonioContent : Fragment() {

    // TODO Use binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frg_antonio_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnFrgAntonioCalculator).setOnClickListener {
            findNavController().navigate(R.id.toFrgAntonioCalculadora)
        }
        view.findViewById<Button>(R.id.btnFrgAntonioPresenter).setOnClickListener {
            findNavController().navigate(R.id.toFrgAntonioPresenter)
        }
    }
}

