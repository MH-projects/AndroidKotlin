package com.mh.basickotlin.ui.manuel.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.R

class ActManuelMain : AppCompatActivity() {

    private lateinit var btnManuel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_manuel_main)

        btnManuel = findViewById(R.id.btnManuel)

        btnManuel.setOnClickListener {
            println("Click Manuel")
        }
    }
}
