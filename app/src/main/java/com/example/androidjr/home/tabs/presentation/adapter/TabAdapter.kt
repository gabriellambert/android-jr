package com.example.androidjr.home.tabs.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidjr.home.tabs.presentation.ui.AllFragment
import com.example.androidjr.home.tabs.presentation.ui.AndroidFragment
import com.example.androidjr.home.tabs.presentation.ui.FlutterFragment
import com.example.androidjr.home.tabs.presentation.ui.IosFragment
import com.example.androidjr.home.utilities.TOTAL_TABS

class TabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = TOTAL_TABS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment()
            1 -> AndroidFragment()
            2 -> IosFragment()
            else -> FlutterFragment()
        }
    }
}