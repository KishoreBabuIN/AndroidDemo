package com.kishorebabu.gorillaschallenge.data.repository.di

import com.kishorebabu.gorillaschallenge.data.repository.PostRepositoryImpl
import com.kishorebabu.gorillaschallenge.data.repository.UserRepositoryImpl
import com.kishorebabu.gorillaschallenge.domain.repository.PostRepository
import com.kishorebabu.gorillaschallenge.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface RepositoryModule {
    @Binds
    fun bindPostRepository(impl: PostRepositoryImpl): PostRepository

    @Binds
    fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}