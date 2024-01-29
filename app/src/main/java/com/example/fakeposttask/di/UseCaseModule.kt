package com.example.mealzapp.di

import com.example.domain.repo.PostsRepo
import com.example.fakeposttask.domain.usecases.GetPostById
import com.example.fakeposttask.domain.usecases.GetPosts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPostsUseCase(postsRepo: PostsRepo) : GetPosts {
        return GetPosts(postsRepo)
    }

    @Provides
    fun provideGetPostByIdUseCase(postsRepo: PostsRepo) : GetPostById {
        return GetPostById(postsRepo)
    }
}