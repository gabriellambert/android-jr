package com.example.androidjr.home.tabs.presentation.adapter

import com.example.androidjr.home.tabs.presentation.ui.IosFragment
import com.example.androidjr.home.tabs.presentation.ui.AndroidFragment
import com.example.androidjr.home.tabs.presentation.ui.AllFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidjr.profile.presentation.ui.EditProfileFragment

internal class TabAdapter(fm: FragmentManager, private var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> AllFragment()
            1 -> AndroidFragment()
            2 -> EditProfileFragment()

            else -> getItem(position)
        }
    }
}