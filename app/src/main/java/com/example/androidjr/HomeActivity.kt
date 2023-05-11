package com.example.androidjr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjr.Adapter.Tab
import com.example.androidjr.Fragments.BottomNavigation.HomeFragment
import com.example.androidjr.Fragments.BottomNavigation.ListFragment
import com.example.androidjr.Fragments.BottomNavigation.ProfileFragment
import com.example.androidjr.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {
    private var binding: ActivityHomeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setupTabLayout()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding?.bottomNavigation!!.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.ic_roles -> HomeFragment()
                R.id.ic_bookmarks -> ListFragment()
                else -> ProfileFragment()
            }
        }
    }

    private fun setupTabLayout(){
        binding!!.tabLayout.apply {
            addTab(binding!!.tabLayout.newTab().setText("Home"))
            addTab(binding!!.tabLayout.newTab().setText("Profile"))
            addTab(binding!!.tabLayout.newTab().setText("Settings"))
            tabGravity = TabLayout.GRAVITY_FILL
        }
        val adapter = Tab(supportFragmentManager, binding!!.tabLayout.tabCount)
        binding!!.viewPager.adapter = adapter

        binding!!.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding!!.tabLayout))
        binding!!.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding!!.viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}