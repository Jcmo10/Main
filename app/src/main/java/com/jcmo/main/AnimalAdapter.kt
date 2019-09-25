package com.jcmo.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.animal_item.view.*

class AnimalAdapter:  RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalAdapter.AnimalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.animal_item,parent,false)
        return AnimalViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listAnimal?.size!!
    }

    override fun onBindViewHolder(holder: AnimalAdapter.AnimalViewHolder, position: Int) {
        val animal = listAnimal!![position]
        holder.loadItem(animal)
    }

    private var listAnimal: MutableList<Animal>? = null

    private var context : Context? = null
    constructor(listAnimal: MutableList<Animal>,context: Context){
        this.listAnimal = listAnimal
        this.context = context
    }

    class AnimalViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun loadItem(animal: Animal){

            itemView.tNombreani.text = animal.nombre
            itemView.tnumero.text = animal.num
            itemView.tpeso.text = animal.peso


            itemView.tedad.text = animal.edad
            itemView.tSexo.text = animal.sexo


            itemView.tpadre.text = animal.padre
            itemView.tmadre.text = animal.madre

            itemView.tfotoanimal.setImageResource(animal.foto!!)


            itemView.setOnClickListener{
                Toast.makeText(itemView.context,animal.nombre, Toast.LENGTH_SHORT).show()
            }

        }



    }
}