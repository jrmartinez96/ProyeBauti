package com.josemartinez.proyectofinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.josemartinez.proyectofinal.databinding.FragmentCrearDispositivoBinding



class CrearDispositivo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Crear Dispositivo"

        // Crear binding
        val binding: FragmentCrearDispositivoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_crear_dispositivo, container, false)
        // Crear evento al hacer click en boton
        binding.buttonGuardarxx.setOnClickListener(
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            Navigation.createNavigateOnClickListener(R.id.action_crearDispositivo_to_listaDeDispositivosFragment)
        )

        binding.buttonCancelar.setOnClickListener(
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            Navigation.createNavigateOnClickListener(R.id.action_crearDispositivo_to_listaDeDispositivosFragment)
        )
        binding.buttonAyuda.setOnClickListener(
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            Navigation.createNavigateOnClickListener(R.id.action_crearDispositivo_to_preguntasFrecuentas)
        )

        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_crear_dispositivo, container, false)
    }
}
