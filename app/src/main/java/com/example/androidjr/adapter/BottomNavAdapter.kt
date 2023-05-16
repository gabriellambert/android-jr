package com.example.androidjr.adapter

import com.example.androidjr.ui.fragment.navigation.HomeFragment
import com.example.androidjr.ui.fragment.navigation.ProfileFragment
import com.example.androidjr.ui.fragment.navigation.ListFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class BottomNavAdapter(fm: FragmentManager, private var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> HomeFragment()
            1 -> ListFragment()
            2 -> ProfileFragment()
            else -> getItem(position)
        }
    }
}