package com.example.ca2restaurantapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import android.content.Intent
import android.content.res.Configuration
import java.util.Locale

class ChangeLanguage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_change_language)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<Button>(R.id.button5)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        fun setLocale(languageCode: String) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)

            val config = Configuration(resources.configuration)
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
            recreate()
        }
        val but = findViewById<Button>(R.id.button4)
        but.setOnClickListener{
            val radioGroup = findViewById<RadioGroup>(R.id.rdgroup)
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            when(selectedRadioButtonId) {
                R.id.radioButton1 -> setLocale("hi")
                R.id.radioButton2 -> setLocale("en")
                R.id.radioButton3 -> setLocale("te")
                R.id.radioButton4 -> setLocale("ar")
                R.id.radioButton5 -> setLocale("es")
            }
        }
    }
}