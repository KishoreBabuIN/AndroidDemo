package com.kishorebabu.posts.data.repository.di

import com.kishorebabu.posts.data.repository.PostRepositoryImpl
import com.kishorebabu.posts.data.repository.UserRepositoryImpl
import com.kishorebabu.posts.domain.repository.PostRepository
import com.kishorebabu.posts.domain.repository.UserRepository
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