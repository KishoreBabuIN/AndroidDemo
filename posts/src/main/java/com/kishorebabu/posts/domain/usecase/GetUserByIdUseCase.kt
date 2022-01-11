package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.User
import io.reactivex.rxjava3.core.Single

interface GetUserByIdUseCase {
    operator fun invoke(id: String): Single<SimpleResult<User>>
}