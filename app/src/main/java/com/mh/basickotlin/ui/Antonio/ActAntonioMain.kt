package com.mh.basickotlin.ui.Antonio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.mh.basickotlin.R

class ActAntonioMain : AppCompatActivity() {
    private lateinit var imbtn:ImageButton
    private lateinit var btnSuma:Button
    private lateinit var btnResta:Button
    private lateinit var btnMulti:Button
    private lateinit var btnDiv:Button
    private lateinit var btnuno:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_antonio_main)
        btnSuma=findViewById(R.id.btnSuma)
    }
}