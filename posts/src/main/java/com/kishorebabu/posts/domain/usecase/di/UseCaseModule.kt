package com.kishorebabu.posts.domain.usecase.di

import com.kishorebabu.posts.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface UseCaseModule {
    @Binds
    fun bindGetAllPostsUseCase(impl: GetAllPostsUseCaseImpl): GetAllPostsUseCase

    @Binds
    fun bindGetPostByIdUseCase(impl: GetPostByIdUseCaseImpl): GetPostByIdUseCase

    @Binds
    fun bindGetUserByIdUseCase(impl: GetUserByIdUseCaseImpl): GetUserByIdUseCase
}