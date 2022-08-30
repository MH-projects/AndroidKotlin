package com.mh.basickotlin.antonio.view.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgAntonioCalculadoraBinding

class FrgAntonioPresenter : Fragment() {

    private lateinit var binding: FrgAntonioCalculadoraBinding

    private val name = "Antonio"
    private val surname = "Barrientos Rios"
    private var age = 25
    private val school = "TESCHA"
    private var state = "CDMX"
    private var work = "GS"
    private var debilidades = "distraccion rapida"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAntonioCalculadoraBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvPresenterAntonio.text= HtmlCompat.fromHtml(
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


