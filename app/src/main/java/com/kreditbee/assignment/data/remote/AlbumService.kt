package com.kreditbee.assignment.data.remote

import com.kreditbee.assignment.model.AlbumDetailsListResponse
import com.kreditbee.assignment.model.AlbumListResponse
import com.kreditbee.assignment.model.AlbumResponse
import com.kreditbee.assignment.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
interface AlbumService {

    @GET(Constants.ALBUM_URL)
    suspend fun getAlbums(): Response<AlbumListResponse>

    @GET("${Constants.ALBUM_DETAILS_URL}{albumId}")
    suspend fun getAlbumDetails(@Path("albumId") albumId: Int): Response<AlbumDetailsListResponse>
}
