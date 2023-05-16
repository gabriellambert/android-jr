package com.example.androidjr.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        goToHomeScreen()
    }

    private fun goToHomeScreen() {
        binding.buttonGoogleLogin.setOnClickListener {
            Intent(this@MainActivity, HomeActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}