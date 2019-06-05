package com.josemartinez.proyectofinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.josemartinez.proyectofinal.databinding.FragmentCrearLugarBinding



class crearLugar : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var bundle: Bundle
    private lateinit var userDocument: DocumentSnapshot

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Crear Lugar"
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


        // Crear binding
        val binding: FragmentCrearLugarBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_crear_lugar, container, false)

        // Crear evento al hacer click en boton
        binding.buttonCasa.setOnClickListener{
            goToNext("casa", it)
        }

        // Crear evento al hacer click en boton
        binding.buttonEmpresa.setOnClickListener{
            goToNext("empresa", it)
        }
        //simpre se pone saber por que
        return binding.root


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_crear_lugar, container, false)
    }

    fun goToNext(casoType: String, view: View) {
        val caso = mutableMapOf<String, String>()
        caso["tipo"] = casoType

        db.collection("users").document(userDocument.id).collection("casos").add(caso as MutableMap<String, Any>).addOnCompleteListener {
            if(it.isSuccessful){
                val listaId = it.result!!.id
                bundle.putString("lista_id", listaId)
            }
        }
    }

}
