package com.jcmo.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
    }

    override fun onBackPressed() {

        intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }

}
