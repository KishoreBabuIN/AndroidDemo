package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.repository.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class GetAllPostsUseCaseImpl @Inject constructor(
    private val postRepository: PostRepository
) : GetAllPostsUseCase {
    override fun invoke(): Single<SimpleResult<List<Post>>> {
        return postRepository.getAllPosts()
    }
}