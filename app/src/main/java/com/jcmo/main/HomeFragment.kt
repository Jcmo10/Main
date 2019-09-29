package com.jcmo.main


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.ClassCastException

class HomeFragment : Fragment(){

    private var interfaz : comunicador ?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val context: Context


        root.tinfo.text = arguments?.getString("Emaila")+"\nas\ndfasdasdasd"

        root.tAñAnimal.setOnClickListener{
            /*val animalesFragment = AnimalesFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.contenedor,animalesFragment)?.addToBackStack(null)?.commit()*/
            interfaz?.cambiarfraganimal(true)
        }

        root.tAñTrabajador.setOnClickListener {
            val intent = Intent(this.context, TrabajadoresActivity::class.java)
            startActivity(intent)
            //activity?.finish()
        }

        root.tAñveterianrio.setOnClickListener {
            interfaz?.cambiarfragevent(true)
        }

        root.tAñevento.setOnClickListener {
            interfaz?.cambiarfragevent(true)
        }
        return root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            interfaz = context as comunicador
        }catch (e: ClassCastException){
            Log.d("exception", e.toString())
        }
    }
}
