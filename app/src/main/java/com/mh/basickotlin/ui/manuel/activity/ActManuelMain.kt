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
import com.mh.basickotlin.ui.pablo.activity.ActPabloMain

class ActManuelMain : AppCompatActivity() {

    private lateinit var btnManuel: Button
    private lateinit var btnPablo: Button
    private lateinit var btnJuan: Button
    private lateinit var btnAngel: Button
    private lateinit var btnJosue: Button
    private lateinit var btnAntonio: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_manuel_main)

        btnAngel = findViewById(R.id.btnAngel)
        btnManuel = findViewById(R.id.btnManuel)
        btnPablo = findViewById(R.id.btnPablo)
        btnAntonio = findViewById(R.id.btnAntonio)
        btnJuan = findViewById(R.id.btnJuan)
        btnJosue = findViewById(R.id.btnJosue)

        btnManuel.setOnClickListener(ActManuelCalculator::class.java)
        btnAngel.setOnClickListener(ActAngelMain::class.java)
        btnPablo.setOnClickListener(ActPabloMain::class.java)
        btnJuan.setOnClickListener(ActJuanMain::class.java)
        btnJosue.setOnClickListener(ActJosueMain::class.java)
        btnAntonio.setOnClickListener(ActAntonioMain::class.java)
    }

    private fun <T> Button.setOnClickListener(_class: Class<T>) {
        setOnClickListener {
            startActivity(Intent(this@ActManuelMain, _class))
        }
    }
}
