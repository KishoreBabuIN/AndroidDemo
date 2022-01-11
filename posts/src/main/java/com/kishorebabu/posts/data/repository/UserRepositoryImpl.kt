package com.kishorebabu.posts.data.repository

import com.kishorebabu.core.Mapper
import com.kishorebabu.core.NetworkResultMapper
import com.kishorebabu.core.SimpleResult
import com.kishorebabu.core.mapToResult
import com.kishorebabu.posts.data.network.api.JsonPlaceholderApi
import com.kishorebabu.posts.data.network.model.UserDto
import com.kishorebabu.posts.domain.model.User
import com.kishorebabu.posts.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val api: JsonPlaceholderApi,
    private val mapper: Mapper<UserDto, User>,
    private val networkResultMapper: NetworkResultMapper,
) : UserRepository {
    private val userInMemoryMap = mutableMapOf<String, User>()

    override fun getUserById(id: String): Single<SimpleResult<User>> {
        return userInMemoryMap[id]?.let {
            Single.just(SimpleResult.success(it))
        } ?: run {
            api.getUserById(id)
                .map { mapper.map(it) }
                .mapToResult(networkResultMapper)
        }
    }
}