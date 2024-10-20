package com.example.checkboxandradiobuttons

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.widget.*

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

        val button1 = findViewById<Button>(R.id.button1)
        val radiogrp = findViewById<RadioGroup>(R.id.radiogrp)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView = findViewById<TextView>(R.id.textView)
        button1.setOnClickListener {
            val checkedRadioButtonId = radiogrp.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(checkedRadioButtonId)
            val onions = checkBox.isChecked
            val panner = checkBox2.isChecked
            val corn = checkBox3.isChecked
            val string = "You ordered a ${radioButton.text} Pizza with the following toppings: "+
                    "${if (onions) "Onions, " else ""}${if (panner) "Panner, " else ""}${if (corn) "Corn" else ""}"
            textView2.text = string
        }
    }
}