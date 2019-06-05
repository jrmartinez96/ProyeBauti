package com.josemartinez.proyectofinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.josemartinez.proyectofinal.databinding.FragmentListaDeDispositivosBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore



class ListaDeDispositivosFragment : Fragment() {

    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Lista de dispositivos"
        // Crear binding
        val binding: FragmentListaDeDispositivosBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_de_dispositivos, container, false)

        // Crear evento al hacer click en boton
        binding.buttonTelevisor.setOnClickListener{
            goToNext(it, "televisor")
        }
        binding.buttonRadio.setOnClickListener{
            goToNext(it, "radio")
        }
        binding.buttonComputadora.setOnClickListener{
            goToNext(it, "computadora")
        }
        binding.buttonConsola.setOnClickListener{
            goToNext(it, "consola")
        }

        binding.buttonRefrigerador.setOnClickListener{
            goToNext(it, "refrigeradora")
        }
        binding.buttonMicroondas.setOnClickListener{
            goToNext(it, "microondas")
        }
        binding.buttonCargador.setOnClickListener{
            goToNext(it, "cargador")
        }
        binding.buttonOtros.setOnClickListener{
            goToNext(it, "otro")
        }
        binding.buttonGuardarxx.setOnClickListener{
            goToResults(it)
        }

        bundle = Bundle()
        bundle.putString("user_id", arguments?.getString("user_id"))
        bundle.putString("lista_id", arguments?.getString("lista_id"))


        //siempre se debe retornar esto el return de abajo solo lo comente por que capaz da problema
        return binding.root

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_lista_de_dispositivos, container, false)
    }

    fun goToNext(view: View, tipoDispositivo: String){
        bundle.putString("tipo_dispositivo", tipoDispositivo)

        Navigation.findNavController(view).navigate(R.id.action_listaDeDispositivosFragment_to_crearDispositivo, bundle)
    }

    fun goToResults(view: View){
        Navigation.findNavController(view).navigate(R.id.action_listaDeDispositivosFragment_to_resultados, bundle)
    }


}

