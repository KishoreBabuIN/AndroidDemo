package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.posts.domain.model.User
import com.kishorebabu.posts.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class GetUserByIdUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserByIdUseCase {
    override fun invoke(id: String): Single<User> {
        return userRepository.getUserById(id)
    }
}