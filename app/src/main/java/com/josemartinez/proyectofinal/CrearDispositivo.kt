package com.josemartinez.proyectofinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.google.firebase.firestore.FirebaseFirestore
import com.josemartinez.proyectofinal.databinding.FragmentCrearDispositivoBinding


class CrearDispositivo : Fragment() {


    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Crear Dispositivo"

        db = FirebaseFirestore.getInstance()

        val userId = arguments?.getString("user_id")
        val listaId = arguments?.getString("lista_id")
        val tipoDispositivo = arguments?.getString("tipo_dispositivo")

        // Crear binding
        val binding: com.josemartinez.proyectofinal.databinding.FragmentCrearDispositivoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_crear_dispositivo, container, false)
        // Crear evento al hacer click en boton
        binding.buttonGuardarxx.setOnClickListener{
            val nombre = binding.nombreDispositivo.text.toString()
            val consumo = binding.kwattsInput.text.toString()
            val uso = binding.horasUsoInput.text.toString()
            val marca = binding.marcaInput.text.toString()
            val ano = binding.modeloInput.text.toString()

            if(nombre != "" && consumo != "" && uso != "" && marca != "" && ano != ""){
                val dispositivo = mutableMapOf<String, Any?>()
                dispositivo["tipo"] = tipoDispositivo
                dispositivo["nombre"] = nombre
                dispositivo["comsumo"] = consumo
                dispositivo["uso"] = uso
                dispositivo["marca"] = marca
                dispositivo["anio"] = ano


                db.collection("users").document(userId as String).collection("casos").document(listaId as String).collection("dispositivos").add(dispositivo as MutableMap<String, Any>)
            }

        }
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            //Navigation.createNavigateOnClickListener(R.id.action_crearDispositivo_to_listaDeDispositivosFragment)

        binding.buttonAyuda.setOnClickListener(
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            Navigation.createNavigateOnClickListener(R.id.action_crearDispositivo_to_preguntasFrecuentas)
        )

        return binding.root
    }
}
