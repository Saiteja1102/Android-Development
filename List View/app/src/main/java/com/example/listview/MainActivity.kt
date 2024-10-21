package com.example.listview

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val listView1 = findViewById<ListView>(R.id.listview1)
        val arraylst = arrayOf("Read a Book",
            "Create a Project",
            "Learn Kotlin",
            "Go for a Walk",
            "Go for Shopping",
            "Attending Seminar")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arraylst)
        listView1.adapter = adapter

        listView1.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "You Selected: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}