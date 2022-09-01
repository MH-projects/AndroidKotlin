/*
 * FrgManuelPresentation.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 01/09/2022, 10:00:23
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mh.basickotlin.databinding.FrgManuelPresentationBinding

class FrgManuelPresentation : Fragment() {

    private lateinit var binding: FrgManuelPresentationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgManuelPresentationBinding.inflate(inflater, container, false)
        return binding.root
    }
}
