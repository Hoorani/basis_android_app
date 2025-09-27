package com.example.simpleandroidapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private var clickCount = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val clickButton = findViewById<Button>(R.id.clickButton)
        val counterText = findViewById<TextView>(R.id.counterText)
        
        welcomeText.text = "Welcome to Simple Android App!"
        
        clickButton.setOnClickListener {
            clickCount++
            counterText.text = "Button clicked: $clickCount times"
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
