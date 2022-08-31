/*
 * FrgJuanRecyclerView.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 31/08/2022, 10:45:18
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R

class FrgJuanRecyclerView : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_juan_recycler_view, container, false)
    }
}
