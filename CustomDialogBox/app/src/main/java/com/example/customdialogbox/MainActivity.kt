package com.example.customdialogbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            CustomDialogBox().show(supportFragmentManager, "CustomDialogBox")
        }

    }
}

class CustomDialogBox : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.custom_dialog_box, container, false)

        val button2 = view.findViewById<Button>(R.id.button2) // "Okay" Button
        val button5 = view.findViewById<Button>(R.id.button5) // "Cancel" Button

        button2.setOnClickListener {
            Toast.makeText(requireContext(), "Okay button clicked!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        button5.setOnClickListener {
            dismiss()
        }

        return view
    }
}
