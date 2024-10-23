package com.example.ca2restaurantapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import android.content.Intent

class FinalBillPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_bill_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView6 = findViewById<TextView>(R.id.textView6)
        val string1 = intent.getStringExtra("USR_string1")
        val string2 = intent.getStringExtra("USR_string2")
        val string3 = intent.getStringExtra("USR_string3")
        val string4 = intent.getStringExtra("USR_string4")
        val str = "Hi, "+string4+"\n"+"You booking for the\n"+"Date: "+string1+" at "+"\nTime: "+string2+"\nhas been confirmed."+"\n\nTotal number of persons: "+string3+"\n\n\nThank you!"
        textView6.text = str


        val backButton = findViewById<Button>(R.id.button6)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, ChangeLanguage::class.java)
            startActivity(intent)
        }

    }
}