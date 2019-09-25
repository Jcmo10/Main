package com.jcmo.main


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_animales.view.*

/**
 * A simple [Fragment] subclass.
 */
class AnimalesFragment : Fragment() {

    var animal : MutableList<Animal> = ArrayList()
    var animals : MutableList<Animal> = ArrayList()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_animales, container, false)
        //animal = arguments?.getParcelableArrayList<Animal>("animal")!!
        animal.add(Animal("vaca2","123",R.drawable.vacaprofile,"100Kg","5","Macho","AAA","BBB"))



        root.fab.setOnClickListener { view ->
            val intent = Intent(context, AddanimActivity::class.java)
            startActivity(intent)
            root.recyclerani.isVisible
            root.iayuda.isInvisible
            root.tvtexto.isInvisible
            //activity?.finish()
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //  .setAction("Action", null).show()
        }
        recyclerView  = root.findViewById(R.id.recyclerani)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)

        val animalAdapter = AnimalAdapter(animal,this.requireContext())
        recyclerView.adapter = animalAdapter

        return root
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==123123 && resultCode== Activity.RESULT_OK){


        }
    }*/
}
