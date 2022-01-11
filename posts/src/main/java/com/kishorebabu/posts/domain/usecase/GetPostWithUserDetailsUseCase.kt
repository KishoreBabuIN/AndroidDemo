package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.PostWithUser
import io.reactivex.rxjava3.core.Single

interface GetPostWithUserDetailsUseCase {
    operator fun invoke(postId: String, userId: String): Single<SimpleResult<PostWithUser>>
}