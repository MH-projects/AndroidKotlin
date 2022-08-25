package com.mh.basickotlin.ui.angel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class frgAngelCalculator : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_angel_calculator, container, false)
    }
}
