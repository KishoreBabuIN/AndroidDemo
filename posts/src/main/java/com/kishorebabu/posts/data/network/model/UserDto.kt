package com.kishorebabu.posts.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val address: AddressDto,
    val company: CompanyDto,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)