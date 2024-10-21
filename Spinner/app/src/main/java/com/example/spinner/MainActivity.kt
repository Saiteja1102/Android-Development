package com.example.spinner

import android.os.Bundle
import android.widget.*
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinnerlst = listOf("BH-1","BH-2","BH-3","BH-4","BH-5","BH-6","BH-7")
        val arrayadp = ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerlst)
        arrayadp.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner1.adapter = arrayadp
    }
}