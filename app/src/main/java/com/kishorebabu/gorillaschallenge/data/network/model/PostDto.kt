package com.kishorebabu.gorillaschallenge.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)