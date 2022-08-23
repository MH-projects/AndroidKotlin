package com.mh.basickotlin.ui.manuel.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.R
import com.mh.basickotlin.ui.pablo.activity.ActPabloMain

class ActManuelMain : AppCompatActivity() {

    private lateinit var btnManuel: Button
    private lateinit var btnPablo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_manuel_main)

        btnManuel = findViewById(R.id.btnManuel)
        btnPablo = findViewById(R.id.btnPablo)
        btnManuel.setOnClickListener {
            println("Click Manuel")
        }
        btnPablo.setOnClickListener {
            val intent = Intent(this, ActPabloMain::class.java)
            startActivity(intent)
        }
    }
}
