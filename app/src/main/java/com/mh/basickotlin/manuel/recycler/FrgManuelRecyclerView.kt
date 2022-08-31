/*
 * FrgManuelRecyclerView.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 10:44:10
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R

class FrgManuelRecyclerView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frg_manuel_recycler_view, container, false)
    }
}
