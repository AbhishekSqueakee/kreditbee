package com.kreditbee.assignment.data

import com.kreditbee.assignment.data.remote.RemoteDataSource
import com.kreditbee.assignment.model.AlbumDetailsListResponse
import com.kreditbee.assignment.model.AlbumListResponse
import com.kreditbee.assignment.model.BaseApiResponse
import com.kreditbee.assignment.model.AlbumResponse
import com.kreditbee.assignment.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getAlbum(): Flow<NetworkResult<AlbumListResponse>> {
        return flow<NetworkResult<AlbumListResponse>> {
            emit(safeApiCall { remoteDataSource.getAlbum() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAlbumDetails(albumId: Int): Flow<NetworkResult<AlbumDetailsListResponse>> {
        return flow<NetworkResult<AlbumDetailsListResponse>> {
            emit(safeApiCall { remoteDataSource.getAlbumDetails(albumId) })
        }.flowOn(Dispatchers.IO)
    }

}
