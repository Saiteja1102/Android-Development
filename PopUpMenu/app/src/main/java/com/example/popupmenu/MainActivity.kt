package com.example.popupmenu

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
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

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            showPopUpMenu(it)
        }
    }

    private fun showPopUpMenu(it: View?) {
        val popupMenu = PopupMenu(this, it)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.show()


        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "Item 1 clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.item2 -> {
                    Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.item3 -> {
                    Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }
}