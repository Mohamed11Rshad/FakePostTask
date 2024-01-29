package com.example.fakeposttask.presentation.postsListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeposttask.R
import com.example.fakeposttask.adapters.PostsAdapter
import com.example.fakeposttask.databinding.FragmentPostsListBinding
import com.example.fakeposttask.utils.navKeys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostsListFragment : Fragment() {
    private lateinit var binding: FragmentPostsListBinding
    private lateinit var postsAdapter: PostsAdapter
    private val viewModel: PostsListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postsAdapter = PostsAdapter()

        postsAdapter.onPostClick = { post ->
            val bundle = Bundle().apply {
                putInt(navKeys.postId, post.id!!)
            }
            findNavController().navigate(
                R.id.action_postsListFragment_to_postDetailsFragment,
                bundle
            )
        }

        setupPostsRv()
        viewModel.getPosts()

        lifecycleScope.launch {
            viewModel.categories.collect {
                postsAdapter.differ.submitList(it)
                binding.postsRv.adapter = postsAdapter
            }
        }


    }

    private fun setupPostsRv() {
        binding.postsRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = postsAdapter
        }

    }

}