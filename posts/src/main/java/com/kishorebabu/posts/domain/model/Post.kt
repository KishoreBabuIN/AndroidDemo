package com.kishorebabu.posts.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val body: String,
    val id: String,
    val title: String,
    val user: String
) : Parcelable
