package com.example.androidjr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnGoogle: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoogle = findViewById(R.id.btn_google)

        btnGoogle.setOnClickListener{

            val intent = Intent(this, Home::class.java)
            startActivity(intent)

        }
    }
}