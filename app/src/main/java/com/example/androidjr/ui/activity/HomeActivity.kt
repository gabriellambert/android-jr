package com.example.androidjr.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjr.R
import com.example.androidjr.adapter.Tab
import com.example.androidjr.databinding.ActivityHomeBinding
import com.example.androidjr.ui.fragment.navigation.HomeFragment
import com.example.androidjr.ui.fragment.navigation.ListFragment
import com.example.androidjr.ui.fragment.navigation.ProfileFragment
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setupTabLayout()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.ic_roles -> HomeFragment()
                R.id.ic_bookmarks -> ListFragment()
                else -> ProfileFragment()
            }
        }
    }

    private fun setupTabLayout() {
        binding.tabLayout.apply {
            addTab(binding.tabLayout.newTab().setText("Todos"))
            addTab(binding.tabLayout.newTab().setText("Android"))
            addTab(binding.tabLayout.newTab().setText("Ios"))
            tabGravity = TabLayout.GRAVITY_FILL
        }
        val adapter = Tab(supportFragmentManager, binding.tabLayout.tabCount)
        binding.viewPager.adapter = adapter

        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}