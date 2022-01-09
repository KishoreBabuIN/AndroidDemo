package com.kishorebabu.gorillaschallenge.domain.repository

import com.kishorebabu.gorillaschallenge.domain.model.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUserById(id: String): Single<User>
}