package com.kishorebabu.gorillaschallenge.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kishorebabu.gorillaschallenge.R
import com.kishorebabu.gorillaschallenge.ui.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsListFragment : Fragment(R.layout.fragment_posts_list) {
    private val viewModel by viewModels<PostsListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uiState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is UiState.Content -> Log.d("asdf", "Result: ${it.data.size}.")
                is UiState.Error -> Log.e("asdf", "Error", it.throwable)
                UiState.Loading -> Log.d("asdf", "Loading...")
            }

        })


        viewModel.onViewReady()
    }
}