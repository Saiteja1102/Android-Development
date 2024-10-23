package com.example.ca2restaurantapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import android.content.Intent

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

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ChangeLanguage::class.java)
            startActivity(intent)
        }

        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val submitButton = findViewById<Button>(R.id.button2)
        submitButton.isEnabled = false
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (checkBox.isChecked) {
                submitButton.isEnabled = true
            }
            else{
            submitButton.isEnabled = false
        }
        }
        submitButton.setOnClickListener {
            val intent = Intent(this, FinalBillPage::class.java)
            startActivity(intent)
        }

        val editText1 = findViewById<EditText>(R.id.editTextText1)
        val editText2 = findViewById<EditText>(R.id.editTextText2)
        val editText3 = findViewById<EditText>(R.id.editTextText3)
        val editText4 = findViewById<EditText>(R.id.editTextText4)
        submitButton.setOnClickListener {
            val intent = Intent(this, FinalBillPage::class.java)
            val string1 = editText1.text.toString()
            val string2 = editText2.text.toString()
            val string3 = editText3.text.toString()
            val string4 = editText4.text.toString()
            intent.putExtra("USR_string1", string1)
            intent.putExtra("USR_string2", string2)
            intent.putExtra("USR_string3", string3)
            intent.putExtra("USR_string4", string4)
            startActivity(intent)
        }

    }
}