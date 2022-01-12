package com.kishorebabu.androiddemo.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kishorebabu.androiddemo.ui.UiState
import com.kishorebabu.androiddemo.R
import com.kishorebabu.androiddemo.databinding.FragmentPostDetailsBinding
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.model.PostWithUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details) {
    private val viewModel by viewModels<PostDetailsViewModel>()
    private lateinit var binding: FragmentPostDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostDetailsBinding.bind(view)

        arguments?.getParcelable<Post>("post")?.let {
            viewModel.onPostDetails(it)
            viewModel.uiState.observe(viewLifecycleOwner) {
                when (it) {
                    is UiState.Content -> renderContent(it.data)
                    is UiState.Error -> Log.e("asdf", "Error", it.throwable)
                    UiState.Loading -> Log.d("asdf", "Loading...")
                }
            }
        }
    }

    private fun renderContent(postWithUser: PostWithUser) {
        with(postWithUser) {
            binding.tvTitle.text = post?.title
            binding.tvUser.text = getString(
                R.string.user_name_format,
                user?.name,
                user?.username,
            )
            binding.tvBody.text = post?.body
        }
    }
}