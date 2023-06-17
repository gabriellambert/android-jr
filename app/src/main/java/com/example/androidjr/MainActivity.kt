package com.example.androidjr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.androidjr.databinding.ActivityMainBinding
import com.example.androidjr.home.bottomNavigation.presentation.adapter.BottomNavAdapter

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val position = when (item.itemId) {
                R.id.ic_roles -> 0
                R.id.ic_bookmarks -> 1
                R.id.ic_profile -> 2
                else -> 0
            }
            binding.viewPagerNav.currentItem = position
            true
        }

        val adapter = BottomNavAdapter(supportFragmentManager, binding.bottomNavigation.menu.size())
        binding.viewPagerNav.adapter = adapter

        binding.viewPagerNav.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}