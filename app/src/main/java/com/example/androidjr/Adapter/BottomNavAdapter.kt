package com.example.androidjr.Adapter

import com.example.androidjr.Fragments.BottomNavigation.HomeFragment
import com.example.androidjr.Fragments.BottomNavigation.ProfileFragment
import com.example.androidjr.Fragments.BottomNavigation.ListFragment
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