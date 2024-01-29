package com.example.fakeposttask.domain.usecases

import com.example.domain.repo.PostsRepo
import com.example.fakeposttask.domain.entity.Post

class GetPostById(private val postsRepo: PostsRepo) {
    suspend fun execute(id: Int): Post {
        return postsRepo.getPostById(id)
    }
}