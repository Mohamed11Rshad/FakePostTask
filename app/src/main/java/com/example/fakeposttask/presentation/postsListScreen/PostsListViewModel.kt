package com.example.fakeposttask.presentation.postsListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeposttask.domain.entity.PostsList
import com.example.fakeposttask.domain.usecases.GetPosts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsListViewModel @Inject constructor(
    private val GetPostsUseCase: GetPosts
):ViewModel() {

    private val _posts = MutableStateFlow<PostsList?>(null)
        val categories = _posts.asStateFlow()


    fun getPosts() {
        viewModelScope.launch {
            try {
                _posts.value = GetPostsUseCase()
            } catch (e: Exception) {
                println("Error: $e")
            }
        }
    }

}