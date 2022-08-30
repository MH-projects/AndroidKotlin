package com.mh.basickotlin.ui.angel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgAngelInformationBinding

class frgAngelInformation : Fragment() {

    private lateinit var binding: FrgAngelInformationBinding

    private val name = "Angel Ernesto"
    private val surname = "Morales Varela"
    private var age = 24
    private val school = "TESCHA"
    private var state = "EDOMEX"
    private var work = "Grupo Salinas"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAngelInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvAngelInfo.text = HtmlCompat.fromHtml(
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
