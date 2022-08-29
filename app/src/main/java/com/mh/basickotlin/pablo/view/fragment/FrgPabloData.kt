package com.mh.basickotlin.pablo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgPabloDataBinding

class FrgPabloData : Fragment() {
    private lateinit var binding: FrgPabloDataBinding
    private val name = "Pablo"
    private val surname = "Amaya"
    private var age = 25
    private val school = "UAMI"
    private var state = "CDMX"
    private var work = "Grupo Salinas"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgPabloDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvPabloFullName.text = HtmlCompat.fromHtml(
            getString(
                R.string.full_name,
                name,
                surname,
                age,
                school,
                state,
                work
            ),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
    }
}
