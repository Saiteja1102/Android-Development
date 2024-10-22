package com.example.actionbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    }
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.appmenu,menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.Search -> {
                    Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.home -> {
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_LONG).show()
                    true
                }

                else -> super.onOptionsItemSelected(item)
            }
        }
}