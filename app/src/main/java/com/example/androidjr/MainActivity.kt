package com.example.androidjr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjr.databinding.ActivityMainBinding
import com.example.androidjr.home.domain.entity.params.RoleModel
import com.example.androidjr.home.presentation.ui.RolesFragment
import com.example.androidjr.home.presentation.ui.recyclerview.adapter.ListItemsAdapter
import com.example.androidjr.home.tabs.presentation.adapter.TabAdapter
import com.example.androidjr.profile.presentation.ui.ProfileFragment
import com.example.androidjr.saveRoles.presentation.ui.SaveRolesFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val role = RoleModel()
    private val adapter = ListItemsAdapter(context = this, items = role.items)


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setupTabLayout()
        setupBottomNavigation()
        setupRecycleView()
    }


    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.ic_roles -> RolesFragment()
                R.id.ic_bookmarks -> SaveRolesFragment()
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




}