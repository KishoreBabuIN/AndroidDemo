package com.kishorebabu.gorillaschallenge.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kishorebabu.gorillaschallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsListFragment : Fragment(R.layout.fragment_posts_list) {
    private val viewModel by viewModels<PostsListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewReady()
    }
}