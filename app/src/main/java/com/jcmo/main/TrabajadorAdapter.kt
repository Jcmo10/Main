package com.jcmo.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.trabajador_item.view.*

class TrabajadorAdapter:RecyclerView.Adapter<TrabajadorAdapter.TrabajadorViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): TrabajadorAdapter.TrabajadorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.trabajador_item,parent,false)
        return TrabajadorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTrabajador?.size!!
    }

    override fun onBindViewHolder(holder: TrabajadorAdapter.TrabajadorViewHolder, position: Int) {
        val trabajador = listTrabajador!![position]
        holder.loadItem(trabajador)
           }

    private var listTrabajador: MutableList<Trabajador>? = null

    private var context : Context? = null

    constructor(listTrabajador: MutableList<Trabajador>,context: Context){
        this.listTrabajador = listTrabajador
        this.context = context
    }

    class TrabajadorViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun loadItem(trabajador: Trabajador){

            itemView.tNombre.text = trabajador.nombre


            itemView.tOcupacion.text = trabajador.ocupacion

            itemView.tfoto.setImageResource(trabajador.foto!!)


            itemView.setOnClickListener{
                Toast.makeText(itemView.context,trabajador.nombre, Toast.LENGTH_SHORT).show()
            }

        }

    }

}