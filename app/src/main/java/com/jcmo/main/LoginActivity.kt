package com.jcmo.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var email : String? = null
    var pass : String?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etcorreo = findViewById<EditText>(R.id.etEmaill)
        val etpass = findViewById<EditText>(R.id.etPassl)


        email = intent.extras?.getString("correo").toString()
        pass = intent.extras?.getString("pass").toString()

        btnLogin.setOnClickListener {

            //login()
            var valid : Boolean = false

            var emaill = etcorreo.text.toString()
            var passl = etpass.text.toString()

            if(emaill.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emaill).matches() ){
                etcorreo.error = "Ingrese un Email Valido"

            }else{
                etcorreo.error = null
                valid = true
            }

            if(passl.isEmpty() || passl.length < 6 || passl.length > 10 ){
                etpass.error = "Entre 6 y 10 Carateres"

            }else{
                etpass.error = null
                valid = true
            }
            if(valid){
                if(emaill != email || passl != pass ) {
                    Toast.makeText(this, "Correo o Contraseña no coinciden", Toast.LENGTH_SHORT).show()
                }else{
                    intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("correo", email)
                    intent.putExtra("pass", pass)
                    startActivity(intent)
                    finish()
                }
            }

        }

        tvsignup.setOnClickListener{
            var intent = Intent(this,RegistroActivity::class.java)
            startActivityForResult(intent,1234) //llama una actividad
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1234 && resultCode== Activity.RESULT_OK){
            email = data!!.extras!!.getString("username").toString()
            pass = data!!.extras!!.getString("password").toString()

        }
    }


}
