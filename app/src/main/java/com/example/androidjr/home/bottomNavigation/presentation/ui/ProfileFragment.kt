package com.example.androidjr.home.bottomNavigation.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidjr.databinding.FragmentProfileBinding
import com.example.androidjr.profile.presentation.ui.EditProfileFragment

class ProfileFragment : Fragment() {
    private var _binding:FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        goToEditProfileScreen()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goToEditProfileScreen() {
        binding.buttonEditProfile.setOnClickListener {
            Intent(requireContext(), EditProfileFragment::class.java).apply {
                startActivity(this)
            }
        }
    }
}