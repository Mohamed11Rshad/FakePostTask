package com.example.fakeposttask.domain.entity


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body")
    val body: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null
)