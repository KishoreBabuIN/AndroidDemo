package com.kishorebabu.posts.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    val city: String,
    val geo: GeoDto,
    val street: String,
    val suite: String,
    val zipcode: String
)