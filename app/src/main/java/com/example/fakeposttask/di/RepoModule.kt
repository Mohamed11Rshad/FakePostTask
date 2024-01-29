package com.example.mealzapp.di


import com.example.data.repo.PostsRepoImpl
import com.example.domain.repo.PostsRepo
import com.example.fakeposttask.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun providePostsRepository(apiService: ApiService) : PostsRepo {
        return PostsRepoImpl(apiService)
    }

}