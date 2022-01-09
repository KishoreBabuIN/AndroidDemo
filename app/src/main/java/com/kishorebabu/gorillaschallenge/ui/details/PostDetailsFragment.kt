package com.kishorebabu.gorillaschallenge.ui.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kishorebabu.gorillaschallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details) {
    private val viewModel by viewModels<PostDetailsViewModel>()
}