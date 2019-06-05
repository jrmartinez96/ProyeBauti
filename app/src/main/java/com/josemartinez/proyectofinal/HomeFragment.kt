package com.josemartinez.proyectofinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.support.v7.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.josemartinez.proyectofinal.clasesx.adaptador
import com.josemartinez.proyectofinal.clasesx.cartillas
import com.josemartinez.proyectofinal.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.ArrayList

class HomeFragment : Fragment() {


    //declaramos nuestros elementos necesarios como listas y el mismo recicle para trabajar

    public var listaRecicle: RecyclerView?=null
    public var miAdaptador: RecyclerView.Adapter<*>?=null
    public var v:View?=null
    var listaProductosx : ArrayList<cartillas> = ArrayList()
    //lo necesitamos para almacenarlo
    var prelistaProductosx : ArrayList<String> = ArrayList()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Lista de Lugares"

        //este for es solo ejemplo para determinar si funciona correctamente el recicleview
        for (i in 0..20){
            val cartillax: cartillas
            cartillax= cartillas()
            var nombre="cajas $i"
            var codigo="1234"
            var cantidadw=i
            cartillax.horas=cantidadw
            cartillax.nombre=nombre
            cartillax.consumo=codigo.toInt()
            listaProductosx!!.add(cartillax)
        }
        // para agregar elementos a lista
        // Crear binding


          val bindingDos: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

          //listaRecicle=bindingDos.recicleVista

          // v=inflater.inflate(R.layout.fragment_home,container,false)
          //listaRecicle=v.findViewById(R.id.recicleVista)
         //  listaRecicle.layoutManager=LinearLayoutManager(this.context)
         //  var listaRecicle=findViewById(R.id.reciclevista) as RecyclerView
         //  var mLayountManager=LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
         // listaRecicle!!.layoutManager=mLayountManager
         // miAdaptador= adaptador(listaProductosx)
        //  listaRecicle!!.adapter=miAdaptador

        // Crear binding
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // Crear evento al hacer click en boton
        binding.botonCasoN.setOnClickListener(
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_crearLugar)
        )
        // Retornar esto siempre
        return binding.root


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }


}
