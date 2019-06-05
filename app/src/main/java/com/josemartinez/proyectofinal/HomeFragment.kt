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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.josemartinez.proyectofinal.clasesx.adaptador
import com.josemartinez.proyectofinal.clasesx.cartillas
import com.josemartinez.proyectofinal.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.ArrayList

class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var bundle: Bundle
    private lateinit var userDocument: DocumentSnapshot


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

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        bundle = Bundle()

        val email = auth.currentUser?.email

        db.collection("users").whereEqualTo("email", email).get().addOnCompleteListener {

            if(it.isSuccessful){
                userDocument = it.result!!.documents[0]

                bundle.putString("user_id", userDocument.id)
            }

        }

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

        // Crear binding
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // Crear evento al hacer click en boton
        binding.botonCasoN.setOnClickListener{
            goToNext("empresa", it)
        }
        // Retornar esto siempre
        return binding.root
    }

    fun goToNext(casoType: String, view: View) {
        val caso = mutableMapOf<String, String>()
        caso["tipo"] = casoType

        db.collection("users").document(userDocument.id).collection("casos").add(caso as MutableMap<String, Any>).addOnCompleteListener {
            if(it.isSuccessful){
                val listaId = it.result!!.id
                bundle.putString("lista_id", listaId)
                Navigation.findNavController(view)
                    .navigate(R.id.action_crearLugar_to_listaDeDispositivosFragment, bundle)
            }
        }
    }
}
