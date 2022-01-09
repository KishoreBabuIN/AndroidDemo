package com.kishorebabu.gorillaschallenge.data.network.api

import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import com.kishorebabu.gorillaschallenge.data.network.model.UserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderApi {
    @GET("/posts")
    fun getAllPosts(): Single<List<PostDto>>

    @GET("/users/{id}")
    fun getUserById(@Path("id") id: String): Single<UserDto>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: String): Single<PostDto>
}