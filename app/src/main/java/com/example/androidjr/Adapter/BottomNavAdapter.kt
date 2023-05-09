package com.example.androidjr.Adapter

import com.example.androidjr.Fragments.BottomNavigation.Home
import com.example.androidjr.Fragments.BottomNavigation.Perfil
import com.example.androidjr.Fragments.BottomNavigation.List
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class BottomNavAdapter(fm: FragmentManager, private var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> Home()
            1 -> List()
            2 -> Perfil()
            else -> getItem(position)
        }
    }
}