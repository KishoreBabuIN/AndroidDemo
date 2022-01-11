package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.Post
import io.reactivex.rxjava3.core.Single

interface GetPostByIdUseCase {
    operator fun invoke(id: String): Single<SimpleResult<Post>>
}