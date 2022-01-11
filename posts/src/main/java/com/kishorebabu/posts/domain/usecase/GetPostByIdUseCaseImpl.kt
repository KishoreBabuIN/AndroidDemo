package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.repository.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPostByIdUseCaseImpl @Inject constructor(
    private val postRepository: PostRepository
) : GetPostByIdUseCase {
    override fun invoke(id: String): Single<SimpleResult<Post>> {
        return postRepository.getPostById(id)
    }
}