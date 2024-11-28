package com.kreditbee.assignment.view

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kreditbee.assignment.R
import com.kreditbee.assignment.databinding.FragmentAlbumDetailsBinding
import com.kreditbee.assignment.model.AlbumDetailsResponse
import com.kreditbee.assignment.utils.NetworkResult
import com.kreditbee.assignment.utils.Utils
import com.kreditbee.assignment.viewmodel.MainViewModel
import java.util.*

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class AlbumDetailsFragment: Fragment() {

    private val mainViewModel by viewModels<MainViewModel>()

    companion object {
        private const val ALBUM_ID = "ALBUM_ID"
        fun newInstance(albumId: Int): Fragment {
            val fragment = AlbumDetailsFragment()
            val bundle = Bundle()
            bundle.putInt(ALBUM_ID, albumId)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var _binding: FragmentAlbumDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAlbumDetailsBinding.inflate(layoutInflater)
        arguments?.let {
            fetchData(arguments?.getInt(ALBUM_ID)?: 0)
        }
    }

    private fun fetchData(albumId: Int) {
        fetchResponse(albumId)
        mainViewModel.responseDetails.observe(requireActivity()) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        initUI(response.data.responseList)
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

    private fun fetchResponse(albumId: Int) {
        mainViewModel.fetchAlbumDetailsResponse(albumId)
    }

    private fun initUI(response: ArrayList<AlbumDetailsResponse>) {
        _binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        _binding.recyclerView.adapter = AlbumDetailsAdapter(requireContext(), response)
    }

}