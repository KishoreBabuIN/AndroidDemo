package com.kishorebabu.posts.domain.model

data class PostWithUser(
    var id: String? = null,
    var post: Post? = null,
    var user: User? = null,
)
