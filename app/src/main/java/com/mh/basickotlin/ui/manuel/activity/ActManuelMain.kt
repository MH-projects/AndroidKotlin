package com.mh.basickotlin.ui.manuel.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.R
import com.mh.basickotlin.ui.Antonio.ActAntonioMain

class ActManuelMain : AppCompatActivity() {

    private lateinit var btnManuel: Button
    private lateinit var btnAntonio:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_manuel_main)

        btnManuel = findViewById(R.id.btnManuel)
        btnManuel.setOnClickListener {
            println("Click Manuel")
        }
        btnAntonio = findViewById(R.id.btnAntonio)
        btnAntonio.setOnClickListener {
            println("Click Antonio")
            val intent1 = Intent(this,ActAntonioMain::class.java)
            startActivity(intent1)
        }
    }
}
