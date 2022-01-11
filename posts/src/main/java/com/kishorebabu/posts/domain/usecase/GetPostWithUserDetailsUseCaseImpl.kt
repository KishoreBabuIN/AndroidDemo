package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.Result
import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.PostWithUser
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPostWithUserDetailsUseCaseImpl @Inject constructor(
    private val getPostByIdUseCase: GetPostByIdUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : GetPostWithUserDetailsUseCase {
    override fun invoke(postId: String, userId: String): Single<SimpleResult<PostWithUser>> {
        return getPostByIdUseCase(postId)
            .zipWith(
                getUserByIdUseCase(userId)
            ) { postResult, userResult ->
                val postWithUser = PostWithUser()
                var hasFailure = false

                postResult.fold(success = {
                    postWithUser.apply {
                        id = it.id
                        post = it
                    }
                }, failure = {
                    hasFailure = true
                })
                userResult.fold(success = {
                    postWithUser.apply {
                        user = it
                    }
                }, failure = {
                    hasFailure = true
                })

                if (hasFailure) {
                    Result.Failure(Throwable(""))
                } else {
                    Result.Success(postWithUser)
                }
            }
    }
}