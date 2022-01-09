package com.kishorebabu.gorillaschallenge.domain.usecase.di

import com.kishorebabu.gorillaschallenge.domain.usecase.GetAllPostsUseCase
import com.kishorebabu.gorillaschallenge.domain.usecase.GetAllPostsUseCaseImpl
import com.kishorebabu.gorillaschallenge.domain.usecase.GetUserByIdUseCase
import com.kishorebabu.gorillaschallenge.domain.usecase.GetUserByIdUseCaseImpl
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
    fun bindGetUserByIdUseCase(impl: GetUserByIdUseCaseImpl): GetUserByIdUseCase
}