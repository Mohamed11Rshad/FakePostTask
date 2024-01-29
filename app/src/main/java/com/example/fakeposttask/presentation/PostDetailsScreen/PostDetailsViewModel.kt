package com.example.fakeposttask.presentation.PostDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeposttask.domain.entity.Post
import com.example.fakeposttask.domain.usecases.GetPostById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val getPostById: GetPostById
): ViewModel() {

    private val _post = MutableStateFlow<Post?>(null)
    val post = _post.asStateFlow()

    fun getPost(id : Int) {
        viewModelScope.launch {
            try {
                _post.value = getPostById.execute(id)
            } catch (e: Exception) {
                println("Error: $e")
            }
        }
    }

}