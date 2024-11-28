package com.kreditbee.assignment.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
class AlbumDetailsResponse(
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)