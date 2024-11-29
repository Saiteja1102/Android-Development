package com.example.contextmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        registerForContextMenu(textView)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
        menu?.setHeaderTitle("Select an Option")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> {
                Toast.makeText(this,"Item 1 Selected",Toast.LENGTH_LONG).show()
            }
            R.id.item2 -> {
                Toast.makeText(this,"Item 2 Selected",Toast.LENGTH_LONG).show()
            }
            R.id.item3 -> {
                Toast.makeText(this,"Item 3 Selected",Toast.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }
}