package com.jcmo.main


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.ClassCastException


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(){

    private var interfaz : comunicador ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val context: Context

        root.tinfo.text = arguments?.getString("Emaila")+"\nas\ndf"
        /*val navViewB: BottomNavigationView = root.nav_viewB
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val agregarFragment = HomeFragment()
        //textMessage = findViewById(R.id.message2)
        transaction.replace(R.id.contenedor, agregarFragment).commit()
        navViewB.setOnNavigationItemSelectedListener(onNavigationItemSelectedListenerB)
        val homeFragment = HomeFragment()
        transaction.replace(R.id.contenedor, homeFragment).commit()
        val homeFragment = HomeFragment()
                transaction.replace(R.id.contenedor, homeFragment).commit()
        */




        root.tAñAnimal.setOnClickListener{
            //var navViewB: BottomNavigationView? = null
           // val animalesFragment = AnimalesFragment()
            //navViewB = root.nav_viewB
            //navViewB?.selectedItemId = R.id.navigation_dashboard
            //root.nav_viewB.selectedItemId = R.id.navigation_dashboard
            val animalesFragment = AnimalesFragment()
            //animalesFragment.arguments
            // setTargetFragment(animalesFragment,124)

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.contenedor,animalesFragment)?.addToBackStack(null)?.commit()

        }

        root.tAñTrabajador.setOnClickListener {
            val intent = Intent(this.context, TrabajadoresActivity::class.java)
            startActivity(intent)
            //activity?.finish()

        }

        root.tAñveterianrio.setOnClickListener {
            interfaz?.cambiarfragevent(true)
            //val intent = Intent(getContext(), VeterianariaActivity::class.java)
            //startActivity(intent)
          //  val eventosFragment = EventosFragment()
            //eventosFragment.arguments
            //activity?.supportFragmentManager?.beginTransaction()
               // ?.replace(R.id.contenedor,eventosFragment)?.addToBackStack(null)?.commit()
        }

        root.tAñevento.setOnClickListener {
            interfaz?.cambiarfragevent(true)
            //root.nav_viewB.selectedItemId = R.id.navigation_eventos
            //val eventosFragment = EventosFragment()
            //eventosFragment.arguments
            //activity?.supportFragmentManager?.beginTransaction()
               // ?.replace(R.id.contenedor,eventosFragment)?.addToBackStack(null)?.commit()
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
