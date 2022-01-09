package com.kishorebabu.gorillaschallenge.data.network

import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import com.kishorebabu.gorillaschallenge.data.network.model.UserDto
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("/posts")
    fun getAllPosts(): Call<List<PostDto>>

    @GET("/users")
    fun getAllUsers(): Call<List<UserDto>>
}