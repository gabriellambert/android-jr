package com.example.androidjr.adapter

import com.example.androidjr.ui.fragment.tabs.IosFragment
import com.example.androidjr.ui.fragment.tabs.AndroidFragment
import com.example.androidjr.ui.fragment.tabs.AllFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class Tab(fm: FragmentManager, private var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> AllFragment()
            1 -> AndroidFragment()
            2 -> IosFragment()

            else -> getItem(position)
        }
    }
}