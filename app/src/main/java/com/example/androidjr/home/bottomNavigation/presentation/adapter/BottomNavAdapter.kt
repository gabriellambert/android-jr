package com.example.androidjr.home.bottomNavigation.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidjr.home.tabs.presentation.ui.BooksmarkFragment
import com.example.androidjr.home.tabs.presentation.ui.RolesFragment
import com.example.androidjr.home.bottomNavigation.presentation.ui.ProfileFragment

internal class BottomNavAdapter(fm: FragmentManager, private var totalNavs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalNavs
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> RolesFragment()
            1 -> BooksmarkFragment()
            2 -> ProfileFragment()

            else -> getItem(position)
        }
    }
}