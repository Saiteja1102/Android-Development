package com.example.locationpermission

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestLocation()
        }
        else{
            accessLocation()
        }
    }

    private fun requestLocation(){
        val requestLocationLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            isGranted:Boolean -> if(isGranted){
                accessLocation()
            }
            else{
                Toast.makeText(this,"Location permission denied",Toast.LENGTH_SHORT).show()
            }
        }
        requestLocationLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
    }

    private fun accessLocation(){
        Toast.makeText(this,"Location permission granted",Toast.LENGTH_SHORT).show()
    }
}