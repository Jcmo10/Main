package com.jcmo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContactarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactar)


    }

    override fun onBackPressed() {

        //intent = Intent(this,MainActivity::class.java)
        //startActivity(intent)
        //finish()
        super.onBackPressed()
    }
}
