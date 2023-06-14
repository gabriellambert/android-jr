package com.example.androidjr

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.androidjr.databinding.ActivityMainBinding
import com.example.androidjr.home.bottomNavigation.presentation.adapter.BottomNavAdapter
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        setupTabLayout()
        setupBottomNavigation()
        setupRecycleView()
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

            override fun onPageSelected(position: Int) {
                var condi = binding.bottomNavigation.menu.getItem(position)?.isChecked
                condi = true
                if(condi == true) {
                    binding.viewPagerNav.visibility = View.VISIBLE
                    binding.viewPagerTab.visibility = View.GONE
                }else{
                    binding.viewPagerNav.visibility = View.GONE
                    binding.viewPagerTab.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setupTabLayout() {
        binding.tabLayout.apply {
            addTab(binding.tabLayout.newTab().setText("Todos"))
            addTab(binding.tabLayout.newTab().setText("Android"))
            addTab(binding.tabLayout.newTab().setText("Ios"))
            addTab(binding.tabLayout.newTab().setText("Flutter"))
            tabGravity = TabLayout.GRAVITY_FILL
        }
        val adapter = TabAdapter(supportFragmentManager, binding.tabLayout.tabCount)
        binding.viewPagerTab.adapter = adapter

        binding.viewPagerTab.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPagerTab.currentItem = tab?.position ?: 0
                tab?.position?.let { adapterRecyclerView.filterList(it) }
                adapterRecyclerView.notifyDataSetChanged()
                binding.viewPagerNav.visibility = View.GONE
                binding.viewPagerTab.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                binding.viewPagerNav.visibility = View.VISIBLE
                binding.viewPagerTab.visibility = View.GONE
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        return
    }
    private fun setupRecycleView() {
        val recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapterRecyclerView
    }
}