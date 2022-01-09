package com.kishorebabu.gorillaschallenge.domain.usecase

import com.kishorebabu.gorillaschallenge.domain.model.Post
import io.reactivex.rxjava3.core.Single

interface GetAllPostsUseCase {
    operator fun invoke(): Single<List<Post>>
}