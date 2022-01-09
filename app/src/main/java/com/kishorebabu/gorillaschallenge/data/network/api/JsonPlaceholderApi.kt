package com.kishorebabu.gorillaschallenge.data.network.api

import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import com.kishorebabu.gorillaschallenge.data.network.model.UserDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderApi {
    @GET("/posts")
    fun getAllPosts(): Call<List<PostDto>>

    @GET("/users/{id}")
    fun getUserById(@Path("id") id: String): Call<UserDto>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: String): Call<PostDto>
}