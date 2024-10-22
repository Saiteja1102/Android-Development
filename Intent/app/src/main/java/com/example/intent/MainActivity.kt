package com.example.intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import android.content.Intent
import android.net.Uri
import com.google.android.material.internal.ToolbarUtils

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

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            val intent = Intent(this,NextPageIntent::class.java)
            startActivity(intent)
        }

        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setOnClickListener{
            val phone_no = "8500812121"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phone_no")
            startActivity(intent)
        }

        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        imageView3.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            val link = "https://ums.lpu.in/lpuums/"
            intent.data = Uri.parse(link)
            startActivity(intent)
        }

        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        imageView4.setOnClickListener {
            val pho_no = "8500812312"
            val msg = "Hi, Hello This is a Android Developer"
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto:$pho_no")
            intent.putExtra("sms_body",msg)
            startActivity(intent)
        }

        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        imageView5.setOnClickListener{
            val location = "geo:17.4065,78.4772"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(location)
            startActivity(intent)
        }


    }
}