package com.example.alertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sai Teja Alert Box")
            builder.setMessage("I am testing the popUp menu")

            builder.setPositiveButton("Open"){
                dialog,which->
                Toast.makeText(this,"Done U clicked to Open, Opening.......",Toast.LENGTH_LONG).show()
            }

            builder.setNegativeButton("Close"){
                dialog,which ->
                dialog.dismiss()
            }

            val alertDialog = builder.create()
            alertDialog.show()
        }
    }
}