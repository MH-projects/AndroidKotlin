/*
 * ActLoginJuan.kt
 * Android Kotlin Juan
 * Created by Juan Pablo on 04/09/2022, 18:46:29
 * Copyright (c) 2022 Develop-MX. All rights reserved
 */

package com.mh.basickotlin.juan.profile.view.activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.appcompat.app.AppCompatActivity
import com.mh.basickotlin.databinding.ActJuanLoginBinding
import com.mh.basickotlin.juan.profile.view.fragment.FrgContentProfileJuan

class ActLoginJuan : AppCompatActivity() {
    private lateinit var binding: ActJuanLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActJuanLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, FrgContentProfileJuan::class.java).apply {
                putExtra(EXTRA_MESSAGE, "Juan")
            }
            startActivity(intent)
        }
    }
}
