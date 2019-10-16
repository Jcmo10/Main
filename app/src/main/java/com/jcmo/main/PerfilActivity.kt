package com.jcmo.main


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btedit.setOnClickListener {
            intent = Intent(this,EditPerfilActivity::class.java)
            startActivityForResult(intent,1111)
        }

    }

    override fun onBackPressed() {

        //intent = Intent(this,MainActivity::class.java)
        //startActivity(intent)
        //finish()
        super.onBackPressed()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1111 && resultCode== Activity.RESULT_OK){


        }
    }


}
