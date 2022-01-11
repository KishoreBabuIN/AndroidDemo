package com.kishorebabu.gorillaschallenge.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kishorebabu.gorillaschallenge.R
import com.kishorebabu.gorillaschallenge.databinding.FragmentPostsListBinding
import com.kishorebabu.gorillaschallenge.ui.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsListFragment : Fragment(R.layout.fragment_posts_list) {
    private val viewModel by viewModels<PostsListViewModel>()
    private lateinit var binding: FragmentPostsListBinding
    private val postsListAdapter = PostsListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPostsListBinding.bind(view)

        setupViews()
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Content -> {
                    postsListAdapter.setPosts(
                        it.data
                    ) { post ->
                        this.findNavController()
                            .navigate(PostsListFragmentDirections.actionPostDetails(post))
                    }
                }
                is UiState.Error -> Log.e("asdf", "Error", it.throwable)
                UiState.Loading -> Log.d("asdf", "Loading...")
            }
        }


        viewModel.onViewReady()
    }

    private fun setupViews() {
        binding.rvPosts.adapter = postsListAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }
}