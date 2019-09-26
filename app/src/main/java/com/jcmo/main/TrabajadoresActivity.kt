package com.jcmo.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_trabajadores.*

class TrabajadoresActivity : AppCompatActivity() {

     lateinit var recyclerView: RecyclerView
    var trabajador : MutableList<Trabajador> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trabajadores)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //actionBar?.setDisplayHomeAsUpEnabled(true)

        val datosRecibidos = intent.extras
        //var trabajador = datosRecibidos?.getParcelableArrayList<Trabajador>("trabajador")
        //var trabajador = datosRecibidos?.getParcelableArrayList<Trabajador>("trabajador")

        // trabajador = datosRecibidos?.getParcelableArrayList<Trabajador>("trabajador")!!
        //trabajador?.toMutableList()
        trabajador.toMutableList()
        trabajador.add(Trabajador("Jose Ramirez","Administrador",R.drawable.perfil))

        recyclerView = findViewById<RecyclerView>(R.id.recycler2)
        recyclerView.setHasFixedSize(true)

        //recyclerView = RecyclerView(this)

        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        val trabajadorAdapter = TrabajadorAdapter(trabajador,this)
        //val trabajadorAdapter = trabajador?.let { TrabajadorAdapter(it,this) }

        recyclerView.adapter = trabajadorAdapter



        fabtra.setOnClickListener { view ->


            intent = Intent(this,AddtraActivity::class.java)
            startActivityForResult(intent,1234)
            //finish()
           /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
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
        if (requestCode==1234 && resultCode== Activity.RESULT_OK){

            var name = data!!.extras!!.getString("username").toString()
            var ocupacion = data.extras!!.getString("ocupacion").toString()
            trabajador.add(Trabajador(name,ocupacion,R.drawable.perfil))
        }
    }
}
