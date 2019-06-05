package com.josemartinez.proyectofinal.clasesx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josemartinez.proyectofinal.R
import java.util.ArrayList


// esta información fue estraida de :

//Kanojia, R. K. (s.f.). https://tutorial.eyehunts.com. Obtenido de https://tutorial.eyehunts.com: https://tutorial.eyehunts.com/android/recyclerview-android-example-cardview-kotlin/Rohit Kumar Kanojia

class adaptador (private val mDataList: ArrayList<cartillas>) : RecyclerView.Adapter<adaptador.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.casoscartillasz, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cartilla.text = mDataList[position].nombre
        holder.cartillaCantidad.text = mDataList[position].consumo.toString()
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    //clase interna para funcionamineto correcto con recicle View
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var cartilla: TextView
        internal var cartillaCantidad:TextView

        init {
            cartilla = itemView.findViewById<View>(R.id.textUnico) as TextView
            cartillaCantidad = itemView.findViewById<View>(R.id.textoCodigo) as TextView
        }
    }

}