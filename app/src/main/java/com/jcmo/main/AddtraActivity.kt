package com.jcmo.main

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_addtra.*

class AddtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtra)

        var nombre : String? = null
        var ocupacion : String? = null

        val etnombre = findViewById<EditText>(R.id.eNombre)
        val etocupacion = findViewById<EditText>(R.id.eocupacion)



        btnEnviar.setOnClickListener {
            var valid : Boolean = false
            var valid2: Boolean = false



            nombre = etnombre.text.toString()
            ocupacion = etocupacion.text.toString()



            if(nombre!!.isEmpty() ){
                Toast.makeText(this,"Ingrese un Nombre", Toast.LENGTH_SHORT).show()

            }else{
                //etEmaill2.error = null
                valid = true
            }

            if(ocupacion!!.isEmpty() ){
                Toast.makeText(this,"Ingrese una Ocupacion", Toast.LENGTH_SHORT).show()

            }else{
                //etPassl.error = null
                valid2 = true
            }



            if(valid && valid2 ){
                    intent.putExtra("username",nombre )
                    intent.putExtra("ocupacion",ocupacion)
                    setResult(Activity.RESULT_OK, intent)//llama actividad
                    finish()//destruyr actividad

            }


        }


    }
}
