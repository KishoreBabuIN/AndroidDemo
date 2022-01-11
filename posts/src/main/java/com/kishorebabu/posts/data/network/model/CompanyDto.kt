package com.kishorebabu.posts.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CompanyDto(
    val bs: String,
    val catchPhrase: String,
    val name: String
)