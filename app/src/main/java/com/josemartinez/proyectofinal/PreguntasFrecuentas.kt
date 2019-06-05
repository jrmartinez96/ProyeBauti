package com.josemartinez.proyectofinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.josemartinez.proyectofinal.databinding.FragmentPreguntasFrecuentasBinding


class PreguntasFrecuentas : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        (activity as AppCompatActivity).supportActionBar?.title = "Preguntas frecuentes"
        // Crear binding
        val binding:FragmentPreguntasFrecuentasBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_preguntas_frecuentas, container, false)

        // Crear evento al hacer click en boton
        binding.buttonbackx.setOnClickListener(
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            Navigation.createNavigateOnClickListener(R.id.action_preguntasFrecuentas_to_crearDispositivo)
        )
        //siempre se debe poner
        return binding.root

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_preguntas_frecuentes, container, false)
    }


}