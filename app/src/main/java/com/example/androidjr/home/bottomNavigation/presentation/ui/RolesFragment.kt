package com.example.androidjr.home.bottomNavigation.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidjr.databinding.FragmentRolesBinding
import com.example.androidjr.home.tabs.presentation.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout


class RolesFragment : Fragment() {
    private lateinit var binding: FragmentRolesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRolesBinding.inflate(inflater, container, false)
        setupTabLayout()

        return binding.root
    }

    private fun setupTabLayout() {
        binding.tabLayout.apply {
            addTab(binding.tabLayout.newTab().setText("Todos"))
            addTab(binding.tabLayout.newTab().setText("Android"))
            addTab(binding.tabLayout.newTab().setText("Ios"))
            addTab(binding.tabLayout.newTab().setText("Flutter"))
            tabGravity = TabLayout.GRAVITY_FILL
        }
        val adapter = TabAdapter(childFragmentManager, binding.tabLayout.tabCount)
        binding.viewPagerTab.adapter = adapter

        binding.viewPagerTab.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPagerTab.currentItem = tab?.position ?: 0
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}
