package com.kishorebabu.posts.data.mapper.di

import com.kishorebabu.core.ListMapper
import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.mapper.*
import com.kishorebabu.posts.data.network.model.*
import com.kishorebabu.posts.domain.model.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface MapperModule {
    @Binds
    fun bindAddressDtoToEntityMapper(impl: AddressDtoToEntityMapper): Mapper<AddressDto, Address>

    @Binds
    fun bindCompanyDtoToEntityMapper(impl: CompanyDtoToEntityMapper): Mapper<CompanyDto, Company>

    @Binds
    fun bindGeoDtoToEntityMapper(impl: GeoDtoToEntityMapper): Mapper<GeoDto, Geo>

    @Binds
    fun bindPostDtoToEntityMapper(impl: PostDtoToEntityMapper): Mapper<PostDto, Post>

    @Binds
    fun bindUserDtoToEntityMapper(impl: UserDtoToEntityMapper): Mapper<UserDto, User>

    @Binds
    fun bindPostListMapper(impl: PostListDtoMapper): ListMapper<PostDto, Post>
}