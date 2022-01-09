package com.kishorebabu.gorillaschallenge.domain.usecase

import com.kishorebabu.gorillaschallenge.domain.model.Post
import com.kishorebabu.gorillaschallenge.domain.repository.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class GetAllPostsUseCaseImpl @Inject constructor(
    private val postRepository: PostRepository
) : GetAllPostsUseCase {
    override fun invoke(): Single<List<Post>> {
        return postRepository.getAllPosts()
    }
}