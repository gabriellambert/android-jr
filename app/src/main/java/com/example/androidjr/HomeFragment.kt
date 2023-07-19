package com.example.androidjr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.androidjr.databinding.FragmentHomeBinding
import com.example.androidjr.home.domain.entity.params.RoleModel
import com.example.androidjr.home.presentation.adapter.RoleItemAdapter
import com.example.androidjr.home.tabs.presentation.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val role = RoleModel()
    private lateinit var adapter: RoleItemAdapter
    private lateinit var tabAdapter: TabAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRoleList()
        setupTabLayout()

    }

    private fun setUpRoleList() = binding.run {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = RoleItemAdapter(requireContext(), role.items)
        recyclerView.adapter = adapter
    }

    private fun setupTabLayout() {
        tabLayout = binding.tabLayout
        viewPager = binding.viewPager2
        tabAdapter = TabAdapter(childFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText(R.string.all))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.android))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ios))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.flutter))

        viewPager.adapter = tabAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager.currentItem = tab.position
                    adapter.filterList(tab.position)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }



}




