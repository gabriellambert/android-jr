package com.example.androidjr.home.tabs.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidjr.home.tabs.presentation.ui.AllFragment
import com.example.androidjr.home.tabs.presentation.ui.AndroidFragment
import com.example.androidjr.home.tabs.presentation.ui.FluttlerFragment
import com.example.androidjr.home.tabs.presentation.ui.IosFragment

class TabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment()
            1 -> AndroidFragment()
            2 -> IosFragment()
            else -> {
                FluttlerFragment()
            }
        }
    }
}