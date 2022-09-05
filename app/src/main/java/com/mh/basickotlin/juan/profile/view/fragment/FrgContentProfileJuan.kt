/*
 * FrgContentJuan.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 04/09/2022, 18:53:21
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.profile.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.basickotlin.databinding.FrgJuanContentProfileBinding

class FrgContentProfileJuan : Fragment() {
    private lateinit var binding: FrgJuanContentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgJuanContentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


}
