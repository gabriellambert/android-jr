package com.example.androidjr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.androidjr.databinding.ActivityMainBinding
import com.example.androidjr.home.bottomNavigation.presentation.adapter.BottomNavAdapter
import com.example.androidjr.home.domain.entity.params.RoleModel
import com.example.androidjr.home.presentation.adapter.ListItemsAdapter
import com.example.androidjr.home.tabs.presentation.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity() : AppCompatActivity() {

    private val role = RoleModel()
    private val adapter = ListItemsAdapter(context = this, items = role.items)

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setupTabLayout() {
        binding.tabLayout.apply {
            addTab(binding.tabLayout.newTab().setText("Todos"))
            addTab(binding.tabLayout.newTab().setText("Android"))
            addTab(binding.tabLayout.newTab().setText("Ios"))
            tabGravity = TabLayout.GRAVITY_FILL
        }
        val adapter = TabAdapter(supportFragmentManager, binding.tabLayout.tabCount)
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

    private fun setupRecycleView() {
        val recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
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
            binding.viewPager.currentItem = position
            true
        }

        val adapter = BottomNavAdapter(supportFragmentManager, binding.bottomNavigation.menu.size())
        binding.viewPager.adapter = adapter

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                binding.bottomNavigation.menu.getItem(position)?.isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}