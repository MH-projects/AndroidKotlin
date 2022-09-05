/*
 * FrgHomeJuan.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 04/09/2022, 18:49:49
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.profile.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgJuanHomeBinding


class FrgHomeJuan : Fragment() {
    private lateinit var binding: FrgJuanHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_juan_home, container, false)
    }

}
