package com.example.domain.repo

import com.example.fakeposttask.domain.entity.Post
import com.example.fakeposttask.domain.entity.PostsList


interface PostsRepo {
    suspend fun getPostsFromRemote(): PostsList
    suspend fun getPostById(id : Int): Post

}