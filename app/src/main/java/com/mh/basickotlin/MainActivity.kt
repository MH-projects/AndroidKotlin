package com.mh.basickotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    private val name = "Manuel"
    private val surname = "Hidalgo"
    private var age = 27
    private val school = "ESCOM"
    private var state = "CDMX"
    private var work = "Quary"
    private var debilidades = "No saberlo todo"

    private lateinit var tvName: TextView
    private lateinit var tvFullName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tvNameValue)
        tvFullName = findViewById(R.id.tvFullName)

        tvName.text = "$name $surname"

        tvFullName.text = HtmlCompat.fromHtml(
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
