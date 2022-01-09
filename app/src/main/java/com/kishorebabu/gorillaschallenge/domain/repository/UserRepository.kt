package com.kishorebabu.gorillaschallenge.domain.repository

import com.kishorebabu.gorillaschallenge.domain.model.User

interface UserRepository {
    fun getUserById(id: String): User?
}