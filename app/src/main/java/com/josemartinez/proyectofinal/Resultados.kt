package com.josemartinez.proyectofinal


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.josemartinez.proyectofinal.databinding.FragmentResultadosBinding
import com.github.mikephil.charting.charts.*
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.josemartinez.proyectofinal.clasesx.cartillas
import kotlinx.android.synthetic.main.fragment_login.view.*
import java.util.ArrayList


//buttonRinicio



class Resultados : Fragment() {


    public var grafica: BarChart?=null
   // public var graficaw: BarDataSet?=null
   // public var graficax: BarData?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Resultados"
        // Crear binding
        val binding: FragmentResultadosBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_resultados, container, false)

        //creamos una lista de elementos para nuestra gráfica
        var datosa  : ArrayList<BarEntry> = ArrayList()

        //por ahora no lo usaremos
        var datoss  : ArrayList<String> = ArrayList()


        //datos para meter a las graficas
        //aqui se debe modificar el segundo parametro(lo malo es que solo acepta INT entonces se redondea el resultado), el primer parametro dejalos así, el tercero pela.
        //la versión que use de la librerria es algo temprana por diversos motivos use esa

        datosa.add(BarEntry(1f,1,"hola"))
        datosa.add(BarEntry(2f,2,"hola"))
        datosa.add(BarEntry(3f,3,"hola"))
        datosa.add(BarEntry(4f,4,"hola"))
        datosa.add(BarEntry(5f,5,"hola"))
        datosa.add(BarEntry(6f,6,"hola"))
        datosa.add(BarEntry(7f,7,"hola"))
        datosa.add(BarEntry(8f,8,"hola"))

        //por ahora no los usaremos
        //estos dejalos así, son solo las pestañas de la grafica.
        datoss.add("TV")
        datoss.add("Radio")
        datoss.add("PC")
        datoss.add("Consola")
        datoss.add("Refri")
        datoss.add("Micro")
        datoss.add("Cel")
        datoss.add("Otros")


        //ESTO QUE VIENE ESTA BIEN NO LO TOQUES
        var  graficaw= BarDataSet(datosa,"Electrodomesticos")
        binding.graficaEjemplo.animateY(500)
        //var  graficasx= BarDataSet(datoss,"saber que es")
       var graficax=BarData(datoss,graficaw)
        //Color a las barras
        graficaw.setColors(ColorTemplate.COLORFUL_COLORS)

        //separacion(no se uso por complictos de versiones)
      // graficax.setBarWidth=(0.9f)
        binding.graficaEjemplo.setData(graficax)
        //binding.graficaEjemplo.setFitBars(true)

        binding.graficaEjemplo.invalidate()

        // Crear evento al hacer click en boton
        binding.buttonRinicio.setOnClickListener(
            // Navegar al siguiente fragment, le tenes que poner el id de la flechita del archivo de navigation
            Navigation.createNavigateOnClickListener(R.id.action_resultados_to_homeFragment)
        )
        // Retornar esto siempre
        return binding.root



        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_resultados, container, false)
    }


}
