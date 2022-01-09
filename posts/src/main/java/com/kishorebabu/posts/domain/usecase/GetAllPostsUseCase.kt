package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.posts.domain.model.Post
import io.reactivex.rxjava3.core.Single

interface GetAllPostsUseCase {
    operator fun invoke(): Single<List<Post>>
}