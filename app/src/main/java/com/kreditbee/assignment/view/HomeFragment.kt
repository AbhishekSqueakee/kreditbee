package com.kreditbee.assignment.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import com.kreditbee.assignment.R
import com.kreditbee.assignment.databinding.FragmentHomeBinding
import com.kreditbee.assignment.model.AlbumResponse
import com.kreditbee.assignment.utils.NetworkResult
import com.kreditbee.assignment.utils.Utils
import com.kreditbee.assignment.view.adapter.AlbumAdapter
import com.kreditbee.assignment.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class HomeFragment: Fragment() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        fetchData()
    }

    private fun fetchData() {
        fetchResponse()
        mainViewModel.response.observe(requireActivity()) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        setPagerAdapter(response.data.listResponse)
                    }
                }

                is NetworkResult.Error -> {
                    Utils.showToastMessage(requireContext(),
                        response.message?: getString(R.string.empty_response))
                }

                is NetworkResult.Loading -> {
                }
            }
        }
    }

    private fun setupPagerView() {
        _binding.tabs.setupWithViewPager(_binding.viewPager)
    }

    private fun setPagerAdapter(albumList: ArrayList<AlbumResponse>) {
        _binding.viewPager.adapter = AlbumAdapter(childFragmentManager, albumList)
        _binding.viewPager.offscreenPageLimit = 5
        setupPagerView()
    }

    private fun fetchResponse() {
        mainViewModel.fetchAlbumResponse()
    }
}