package org.d3if4014.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4014.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val navController = this.findNavController(R.id.navigationHome)
//        NavigationUI.setupActionBarWithNavController(this,navController)
    }
}
