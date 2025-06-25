package com.example.assignment5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var nameInput: EditText
    private lateinit var greetingText: TextView
    private lateinit var showButton: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.name_edit_text)
        greetingText = findViewById(R.id.greeting_text_view)
        showButton = findViewById(R.id.show_name_button)

        showButton.setOnClickListener{
            val name = nameInput.text.toString()
            if (name.isNotEmpty()){
                greetingText.text = "Hello, $name!"
            }else{
                greetingText.text = "Please Enter the Name"
            }
        }
    }



}