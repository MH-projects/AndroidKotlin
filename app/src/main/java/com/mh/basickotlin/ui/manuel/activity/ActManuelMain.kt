package com.mh.basickotlin.ui.manuel.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.R
import com.mh.basickotlin.ui.juan.activity.ActJuanMain

class ActManuelMain : AppCompatActivity() {

    private lateinit var btnManuel: Button
    private lateinit var btnJuan: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_manuel_main)

        btnManuel = findViewById(R.id.btnManuel)
        btnJuan = findViewById(R.id.btnJuan)
        btnManuel.setOnClickListener {
            println("Click Manuel")
        }
        btnJuan.setOnClickListener {
            val intent = Intent(this, ActJuanMain::class.java)
            startActivity(intent)
        }
    }
}
