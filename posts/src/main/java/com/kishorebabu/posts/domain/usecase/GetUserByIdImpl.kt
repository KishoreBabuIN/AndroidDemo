package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.User
import com.kishorebabu.posts.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetUserByIdImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserById {
    override fun invoke(id: String): Single<SimpleResult<User>> {
        return userRepository.getUserById(id)
    }
}