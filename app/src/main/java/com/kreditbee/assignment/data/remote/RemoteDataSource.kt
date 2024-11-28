package com.kreditbee.assignment.data.remote

import javax.inject.Inject

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class RemoteDataSource @Inject constructor(private val albumService: AlbumService) {

    suspend fun getAlbum() =
        albumService.getAlbums()

    suspend fun getAlbumDetails(albumId: Int) =
        albumService.getAlbumDetails(albumId)

}