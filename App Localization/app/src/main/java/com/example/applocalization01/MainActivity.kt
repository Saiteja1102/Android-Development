package com.example.applocalization01

import android.content.res.Configuration
import android.graphics.Bitmap.Config
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import java.util.*

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

        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinnerlst = listOf("Telugu", "Hindi", "French", "Arabic", "Spanish", "German")
        val arrayadp = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerlst)
        arrayadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayadp

        fun setLocale(languageCode: String){
            val localeapp = Locale(languageCode)
            Locale.setDefault(localeapp)

            val Config = Configuration(resources.configuration)
            Config.setLocale(localeapp)
            resources.updateConfiguration(Config, resources.displayMetrics)
            recreate()
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val selectedItem = spinner.selectedItem.toString()
            when (selectedItem) {
                "Telugu" -> setLocale("te")
                "Hindi" -> setLocale("hi")
                "French" -> setLocale("fr")
                "Arabic" -> setLocale("ar")
                "Spanish" -> setLocale("sp")
                "German" -> setLocale("ge")
            }
        }
    }
}