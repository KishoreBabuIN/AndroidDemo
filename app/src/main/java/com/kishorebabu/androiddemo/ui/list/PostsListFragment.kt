package com.kishorebabu.androiddemo.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kishorebabu.androiddemo.R
import com.kishorebabu.androiddemo.databinding.FragmentPostsListBinding
import com.kishorebabu.androiddemo.ui.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsListFragment : Fragment(R.layout.fragment_posts_list) {
    private val viewModel by viewModels<PostsListViewModel>()
    private var binding: FragmentPostsListBinding? = null
    private val postsListAdapter = PostsListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPostsListBinding.bind(view)

        setupViews()
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Content -> {
                    binding?.loading?.visibility = View.GONE
                    postsListAdapter.submitList(it.data)
                    postsListAdapter.setPostClickListener { post ->
                        this.findNavController()
                            .navigate(
                                PostsListFragmentDirections.actionPostDetails(
                                    post
                                )
                            )
                    }
                }
                is UiState.Error -> {
                    binding?.let {
                        it.loading.visibility = View.GONE
                        Snackbar.make(it.root, R.string.generic_error, Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
                UiState.Loading -> binding?.loading?.visibility = View.VISIBLE
            }
        }


        viewModel.onViewReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setupViews() {
        binding?.rvPosts?.let {
            it.adapter = postsListAdapter
            it.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }
}