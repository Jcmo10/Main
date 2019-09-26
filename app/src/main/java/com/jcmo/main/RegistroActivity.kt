package com.jcmo.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        var email : String? = null
        var pass : String? = null
        var conpass : String? = null

        val etcorreo = findViewById<EditText>(R.id.etCorreo)
        val etpass = findViewById<EditText>(R.id.etPass)
        val etconpass = findViewById<EditText>(R.id.etcCnfirPass)

        var datosRecibidos =intent.extras

        btnsignup.setOnClickListener {
            var valid : Boolean = false
            var valid2: Boolean = false
            var valid3: Boolean = false


            email = etcorreo.text.toString()
            pass = etpass.text.toString()
            conpass = etconpass.text.toString()


            if(email!!.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
                etEmaill2.error = "Ingrese un Email Valido"

            }else{
                etEmaill2.error = null
                valid = true
            }

            if(pass!!.isEmpty() || pass!!.length < 6 || pass!!.length > 10 ){
                etPassl.error = "Entre 6 y 10 Carateres"

            }else{
                etPassl.error = null
                valid2 = true
            }
            if(conpass!!.isEmpty() || conpass!!.length < 6 || conpass!!.length > 10 ){
                etcCnfirPass1.error = "Entre 6 y 10 Carateres"

            }else{
                etcCnfirPass1.error = null
                valid3 = true
            }


            if(valid && valid2 && valid3){
                if(  pass != conpass ) {
                    //Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    etcCnfirPass1.error = "Contraseñas no Coinciden"
                    etPassl.error = "Contraseñas no Coinciden"
                }else{
                    intent.putExtra("username",email )
                    intent.putExtra("password",pass)
                    setResult(Activity.RESULT_OK, intent)//llama actividad
                    finish()//destruyr actividad
                }
            }


        }
    }

}
