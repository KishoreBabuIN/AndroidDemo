package com.kishorebabu.posts.domain.model

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)
