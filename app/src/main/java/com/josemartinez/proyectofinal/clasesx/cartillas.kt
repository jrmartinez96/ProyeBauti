package com.josemartinez.proyectofinal.clasesx

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.josemartinez.proyectofinal.R
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.productoss.*
public var cantidadq:Int=0

//nuestra cartilla debe tener nombre de producto y cantidad
class  cartillas: AppCompatActivity()  {
    //elementos de los card view que necesitamos para determinar datos del elemento estudiado
    var nombre: String? = null
    var consumo:Int=0
    var horas:Int=0
    var marca: String?=null
    var modelo:Int=0
}