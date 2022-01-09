package com.kishorebabu.posts.data.repository

import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.api.JsonPlaceholderApi
import com.kishorebabu.posts.data.network.model.UserDto
import com.kishorebabu.posts.domain.model.User
import com.kishorebabu.posts.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val api: JsonPlaceholderApi,
    private val mapper: Mapper<UserDto, User>
) : UserRepository {
    override fun getUserById(id: String): Single<User> {
        return api.getUserById(id)
            .map { mapper.map(it) }
    }
}