package com.mh.basickotlin.josue.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.mh.basickotlin.R
import com.mh.basickotlin.databinding.FrgJosueWelcomeBinding

class FrgJosueWelcome : Fragment() {

    private lateinit var binding: FrgJosueWelcomeBinding

    // private val tag = FrgJosueWelcome::class.java.simpleName
    private val name = "Josue"
    private val surname = "Cazares"
    private var age = 22
    private val school = "TESCO"
    private var state = "TULTEPEC"
    private var work = "GS"
    private var debilidades = "Soy muy distraido"

    private lateinit var tvName: TextView
    private lateinit var tvFullName: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgJosueWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvName.text = "$name $surname"

        binding.tvFullName.text = HtmlCompat.fromHtml(
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

        Log.i(tag, "Name: $name $surname")
        Log.i(tag, "Age: $age")
        Log.i(tag, "School: $school")
        Log.i(tag, "State: $state")
        Log.i(tag, "Work: $work")
        Log.e(tag, "Debilidad: $debilidades")
    }
}
