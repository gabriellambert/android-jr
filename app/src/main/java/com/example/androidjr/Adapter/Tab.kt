package com.example.androidjr.Adapter

import com.example.androidjr.Fragments.Tabs.Settings
import com.example.androidjr.Fragments.Tabs.Profile
import com.example.androidjr.Fragments.Tabs.Home
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class Tab(fm: FragmentManager, private var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Home()
            1 -> Profile()
            2 -> Settings()

            else -> getItem(position)
        }
    }
}