package com.josemartinez.proyectofinal
/*
    Imports
 */
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.NavigationUI
import androidx.navigation.findNavController
// Internal : DataBinding
import com.josemartinez.proyectofinal.databinding.ActivityMainBinding

/*
    Activity that binds to activity_main.xml layout, Sets up NavigationUI to start a navController
  */
class MainActivity : AppCompatActivity() {

    // Local late initialization variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Instates DrawerLayout to use for NavHostFragment
        drawerLayout = binding.drawerLayout

        // Set the navigation controller to be the navigation.xml and initialize activity
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    // Setup navigation.xml as Navigation Controller and correspond drawerLayout as default layout
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
