package com.example.fakeposttask.data.remote

import com.example.fakeposttask.domain.entity.Post
import com.example.fakeposttask.domain.entity.PostsList
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): PostsList

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id")id : Int): Post

}