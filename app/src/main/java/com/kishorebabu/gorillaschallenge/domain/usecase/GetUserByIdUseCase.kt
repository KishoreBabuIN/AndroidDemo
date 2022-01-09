package com.kishorebabu.gorillaschallenge.domain.usecase

import com.kishorebabu.gorillaschallenge.domain.model.User
import io.reactivex.rxjava3.core.Single

interface GetUserByIdUseCase {
    operator fun invoke(id: String): Single<User>
}