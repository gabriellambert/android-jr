package com.example.androidjr

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        goToHomeScreen()
    }

    private fun goToHomeScreen() {
        binding!!.buttonGoogleLogin.setOnClickListener {
            Intent(this@MainActivity, HomeActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}