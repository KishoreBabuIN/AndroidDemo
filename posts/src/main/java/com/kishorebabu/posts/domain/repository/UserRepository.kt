package com.kishorebabu.posts.domain.repository

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUserById(id: String): Single<SimpleResult<User>>
}