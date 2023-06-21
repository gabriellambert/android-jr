package com.example.androidjr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.viewpager2.widget.ViewPager2
import com.example.androidjr.databinding.ActivityMainBinding
import com.example.androidjr.home.domain.entity.params.RoleModel
import com.example.androidjr.home.presentation.adapter.ListItemsAdapter
import com.example.androidjr.home.tabs.presentation.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val role = RoleModel()
    private var adapterRecyclerView = ListItemsAdapter(context = this, items = role.items)
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapterPager: TabAdapter
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupTabLayout()
        setupRecycleView()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }
    private fun setupTabLayout() {
        tabLayout = binding.tabLayout
        viewPager2 = binding.viewPager2
        adapterPager = TabAdapter(supportFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("Todos"))
        tabLayout.addTab(tabLayout.newTab().setText("Android"))
        tabLayout.addTab(tabLayout.newTab().setText("Ios"))
        tabLayout.addTab(tabLayout.newTab().setText("Flutter"))

        viewPager2.adapter = adapterPager

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                    adapterRecyclerView.filterList(tab.position)
                    adapterRecyclerView.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
    private fun setupRecycleView() {
        val recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapterRecyclerView
    }
}
