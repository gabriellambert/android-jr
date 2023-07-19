package com.example.androidjr.login.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjr.MainActivity
import com.example.androidjr.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToHomeScreen()
    }

    private fun goToHomeScreen() {
        binding.buttonGoogleLogin.setOnClickListener {
            Intent(this@LoginActivity, MainActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}