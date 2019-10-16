package com.jcmo.main

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_addanim.*


class AddanimActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addanim)

        var nomanima : String? = null
        var numanimal : String? = null
        var pesoanimal : String? = null
        var edadanimal : String? = null
        var nompadre : String? = null
        var nommadre : String? = null


        val etnomanimal = findViewById<EditText>(R.id.etnomanimal)
        val etnumanimal = findViewById<EditText>(R.id.etnumanimal)
        val etpesoanimal = findViewById<EditText>(R.id.etpesoanimal)

        val etedadanimal = findViewById<EditText>(R.id.etedadanimal)
        val etnompadre = findViewById<EditText>(R.id.etnompadre)
        val etnommadre = findViewById<EditText>(R.id.etnommadre)

        val radioGroup = findViewById<RadioGroup>(R.id.rgsexo)

        val estado = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(estado)

        //val estado = radioButton.isChecked

        btnAgregarAnimal.setOnClickListener {
            var valid : Boolean = false
            var valid2: Boolean = false
            var valid3: Boolean = false
            var valid4 : Boolean = false
            var valid5: Boolean = false
            var valid6: Boolean = false

            nomanima = etnomanimal.text.toString()
            numanimal = etnumanimal.text.toString()
            pesoanimal = etpesoanimal.text.toString()
            edadanimal = etedadanimal.text.toString()
            nompadre = etnompadre.text.toString()
            nommadre = etnommadre.text.toString()

            if(nomanima!!.isEmpty() ){
                etnomanimal.error = "Ingrese un Nombre"

            }else{
                etnomanimal.error = null
                valid = true
            }

            if(numanimal!!.isEmpty() ){
                etnumanimal.error = "Ingrese un numero"

            }else{
                etnumanimal.error = null
                valid2 = true
            }
            if(pesoanimal!!.isEmpty() ){
                etpesoanimal.error = "Ingrese Peso del animal"

            }else{
                etpesoanimal.error = null
                valid3 = true
            }


            if(edadanimal!!.isEmpty() ){
                etedadanimal.error = "Ingrese un Nombre"

            }else{
                etedadanimal.error = null
                valid4 = true
            }

            if(nompadre!!.isEmpty() ){
                etnompadre.error = "Ingrese un numero"

            }else{
                etnompadre.error = null
                valid5 = true
            }
            if(nommadre!!.isEmpty() ){
                etnommadre.error = "Ingrese Peso del animal"

            }else{
                etnommadre.error = null
                valid6 = true
            }


            if(valid && valid2 && valid3 && valid4 && valid5 && valid6){

                intent.putExtra("nomanimal",nomanima )
                intent.putExtra("numanimal",numanimal)
                intent.putExtra("peso",pesoanimal )
                intent.putExtra("edad",edadanimal)
                intent.putExtra("padre",nompadre )
                intent.putExtra("madre",nommadre)
                intent.putExtra("foto",R.id.ivAnimal)
                intent.putExtra("sexo",radioButton.text)
                intent.putExtra("vis",true)
                /*radioButton.setOnClickListener {
                    var fff = radioGroup.checkedRadioButtonId
                    if (fff==R.id.radio_masculino){
                        Toast.makeText(this,"Macho",Toast.LENGTH_SHORT).show()
                    }
                    if(fff==R.id.radio_femenino){
                        Toast.makeText(this,"Hembra",Toast.LENGTH_SHORT).show()
                    }
                }
                radioGroup.setOnCheckedChangeListener { radioGroup, i ->
                    var fff = radioGroup.checkedRadioButtonId
                    if (i==R.id.radio_masculino){
                        Toast.makeText(this,"Macho",Toast.LENGTH_SHORT).show()
                    }
                    if(i==R.id.radio_femenino){
                        Toast.makeText(this,"Hembra",Toast.LENGTH_SHORT).show()
                    }
                }*/
                var aa :String
                var fff = radioGroup.checkedRadioButtonId
                if (fff==R.id.radio_masculino){
                    aa = "Macho"
                    Toast.makeText(this,aa,Toast.LENGTH_SHORT).show()
                }
                if(fff==R.id.radio_femenino){
                    aa = "Hembra"
                    Toast.makeText(this,aa,Toast.LENGTH_SHORT).show()
                }


                //intent = Intent(this,MainActivity::class.java)
                //startActivity(intent)
                setResult(Activity.RESULT_OK, intent)//llama actividad
                finish()//destruyr actividad

            }


        }
    }



}
