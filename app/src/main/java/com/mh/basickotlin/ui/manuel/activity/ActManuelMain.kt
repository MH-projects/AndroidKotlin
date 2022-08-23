package com.mh.basickotlin.ui.manuel.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.R
import com.mh.basickotlin.ui.Antonio.ActAntonioMain
import com.mh.basickotlin.ui.angel.ActAngelMain
import com.mh.basickotlin.ui.josue.ActJosueMain
import com.mh.basickotlin.ui.juan.activity.ActJuanMain

class ActManuelMain : AppCompatActivity() {

    private lateinit var btnManuel: Button
    private lateinit var btnJuan: Button

    private lateinit var btnAngel: Button
    private lateinit var btnJosue: Button
    private lateinit var btnAntonio: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_manuel_main)
        btnAngel = findViewById(R.id.btnAngel)
        btnManuel = findViewById(R.id.btnManuel)
        btnJuan = findViewById(R.id.btnJuan)
        btnManuel.setOnClickListener {
            println("Click Manuel")
        }
        btnJuan.setOnClickListener {
            val intent = Intent(this, ActJuanMain::class.java)
            startActivity(intent)
        }
        btnJosue = findViewById(R.id.btnJosue)

        btnManuel.setOnClickListener {
            println("Click Manuel")
        }

        btnAngel.setOnClickListener {
            val intent = Intent(this, ActAngelMain::class.java)
            startActivity(intent)
        }

        btnAntonio = findViewById(R.id.btnAntonio)
        btnAntonio.setOnClickListener {
            println("Click Antonio")
            val intent1 = Intent(this, ActAntonioMain::class.java)
            startActivity(intent1)
        }

        btnJosue.setOnClickListener { goToActJosue() }
    }

    private fun goToActJosue() {
        startActivity(Intent(this, ActJosueMain::class.java))
    }
}
