package com.example.android_course

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val principalText: TextView = findViewById(R.id.principalText)
        principalText.apply {
            text = "Hola Mundo!!!"
            setTextColor(Color.BLUE)
            setOnClickListener {
                Toast.makeText(this@MainActivity, "Se ha cliclado en el texto", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val editText: EditText = findViewById(R.id.editText)
        editText.addTextChangedListener {
            if (editText.text.isEmpty()) editText.error = "Campo vacío"
        }

        val autoComplete: AutoCompleteTextView = findViewById(R.id.autoComplete)
        val countries: Array<String> = resources.getStringArray(R.array.countries_array)
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, countries)

        autoComplete.setAdapter(adapter)
    }
}