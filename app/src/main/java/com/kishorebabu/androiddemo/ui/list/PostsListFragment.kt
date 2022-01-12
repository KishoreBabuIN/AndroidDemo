package com.kishorebabu.androiddemo.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kishorebabu.androiddemo.ui.UiState
import com.kishorebabu.androiddemo.R
import com.kishorebabu.androiddemo.databinding.FragmentPostsListBinding
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
                    binding.loading.visibility = View.GONE
                    postsListAdapter.setPosts(
                        it.data
                    ) { post ->
                        this.findNavController()
                            .navigate(
                                com.kishorebabu.androiddemo.ui.list.PostsListFragmentDirections.actionPostDetails(
                                    post
                                )
                            )
                    }
                }
                is UiState.Error -> {
                    binding.loading.visibility = View.GONE
                    Snackbar.make(binding.root, R.string.generic_error, Snackbar.LENGTH_SHORT)
                        .show()
                    Log.e("asdf", "Error", it.throwable)
                }
                UiState.Loading -> binding.loading.visibility = View.VISIBLE
            }
        }


        viewModel.onViewReady()
    }

    private fun setupViews() {
        binding.rvPosts.adapter = postsListAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }
}