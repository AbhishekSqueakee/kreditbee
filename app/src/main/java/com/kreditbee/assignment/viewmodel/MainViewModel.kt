package com.kreditbee.assignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kreditbee.assignment.data.Repository
import com.kreditbee.assignment.model.AlbumDetailsListResponse
import com.kreditbee.assignment.model.AlbumListResponse
import com.kreditbee.assignment.model.AlbumResponse
import com.kreditbee.assignment.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<AlbumListResponse>> = MutableLiveData()
    private val _responseDetails: MutableLiveData<NetworkResult<AlbumDetailsListResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<AlbumListResponse>> = _response
    val responseDetails: LiveData<NetworkResult<AlbumDetailsListResponse>> = _responseDetails

    fun fetchAlbumResponse() = viewModelScope.launch {
        repository.getAlbum().collect { values ->
            _response.value = values
        }
    }

    fun fetchAlbumDetailsResponse(albumId: Int) = viewModelScope.launch {
        repository.getAlbumDetails(albumId).collect { values ->
            _responseDetails.value = values
        }
    }

}