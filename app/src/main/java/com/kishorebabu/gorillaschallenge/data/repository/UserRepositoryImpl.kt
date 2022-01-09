package com.kishorebabu.gorillaschallenge.data.repository

import com.kishorebabu.gorillaschallenge.data.network.api.JsonPlaceholderApi
import com.kishorebabu.gorillaschallenge.data.network.model.UserDto
import com.kishorebabu.gorillaschallenge.domain.model.User
import com.kishorebabu.gorillaschallenge.domain.repository.UserRepository
import com.kishorebabu.gorillaschallenge.utils.Mapper
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