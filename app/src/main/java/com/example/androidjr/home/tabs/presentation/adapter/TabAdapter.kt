package com.example.androidjr.home.tabs.presentation.adapter

import com.example.androidjr.home.tabs.presentation.ui.BooksmarkFragment
import com.example.androidjr.home.tabs.presentation.ui.RolesFragment
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
            0 -> RolesFragment()
            1 -> BooksmarkFragment()
            2 -> EditProfileFragment()

            else -> getItem(position)
        }
    }
}