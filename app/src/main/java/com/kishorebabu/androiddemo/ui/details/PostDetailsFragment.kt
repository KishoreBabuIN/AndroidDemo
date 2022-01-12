package com.kishorebabu.androiddemo.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.kishorebabu.androiddemo.R
import com.kishorebabu.androiddemo.databinding.FragmentPostDetailsBinding
import com.kishorebabu.androiddemo.ui.UiState
import com.kishorebabu.posts.domain.model.PostWithUser
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details) {
    private val viewModel by viewModels<PostDetailsViewModel>()
    private var binding: FragmentPostDetailsBinding? = null
    private val args: PostDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostDetailsBinding.bind(view)

        with(args.post) {
            setupObservers()
            viewModel.onPostDetails(this)
        }
    }

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Content -> renderContent(it.data)
                is UiState.Error -> renderError(it.throwable)
                UiState.Loading -> binding?.loading?.visibility = View.VISIBLE
            }
        }
    }

    private fun renderError(throwable: Throwable) {
        Timber.e(throwable, "Error in loading post details")
        binding?.loading?.visibility = View.GONE
        binding?.layoutRoot?.let {
            showGenericErrorSnackbar(it, { viewModel.retry(args.post) })
        }
    }

    private fun showGenericErrorSnackbar(view: View, onRetry: () -> Unit) {
        Snackbar.make(view, R.string.generic_error, Snackbar.LENGTH_SHORT).apply {
            setAction(R.string.retry) { onRetry() }
            show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun renderContent(postWithUser: PostWithUser) {
        with(postWithUser) {
            binding?.apply {
                loading.visibility = View.GONE
                tvTitle.text = post?.title
                tvUser.text = getString(
                    R.string.user_name_format,
                    user?.name,
                    user?.username,
                )
                tvBody.text = post?.body
            }
        }
    }
}