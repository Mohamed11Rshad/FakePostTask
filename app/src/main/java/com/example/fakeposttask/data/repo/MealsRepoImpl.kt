package com.example.data.repo

import com.example.domain.repo.PostsRepo
import com.example.fakeposttask.data.remote.ApiService

class PostsRepoImpl(private val apiService: ApiService) : PostsRepo{
    override suspend fun getPostsFromRemote() = apiService.getPosts()
    override suspend fun getPostById(id: Int) = apiService.getPostById(id)
}