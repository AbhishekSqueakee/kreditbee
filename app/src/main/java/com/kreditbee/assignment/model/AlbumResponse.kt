package com.kreditbee.assignment.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Abhishek Maurya on 12-12-2021.
 */
data class AlbumResponse(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)
