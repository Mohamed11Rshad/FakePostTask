package com.example.fakeposttask.domain.usecases

import com.example.domain.repo.PostsRepo

class GetPosts(private val postsRepo: PostsRepo) {
    suspend operator fun invoke() = postsRepo.getPostsFromRemote()
}
