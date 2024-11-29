package com.example.applocalization02

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

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

        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val button = findViewById<Button>(R.id.button)
        val listview = findViewById<ListView>(R.id.listview)

        val arraylist = arrayOf("Telugu", "Hindi", "Spanish")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylist)
        listview.adapter = adapter

        listview.setOnItemClickListener { parent, _, position, _ ->
            val selectedLanguage = parent.getItemAtPosition(position).toString()
            when(selectedLanguage){
                "Telugu" -> setLocale("te")
                "Hindi" -> setLocale("hi")
                "Spanish" -> setLocale("es")
            }
        }
    }

    private fun setLocale(Localization: String) {
        val localeapp = Locale(Localization)
        Locale.setDefault(localeapp)
        val config = resources.configuration
        config.setLocale(localeapp)
        resources.updateConfiguration(config, resources.displayMetrics)
        recreate()
    }
}