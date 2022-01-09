package com.kishorebabu.posts.data.mapper

import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.model.PostDto
import com.kishorebabu.posts.domain.model.Post
import javax.inject.Inject

internal class PostDtoToEntityMapper @Inject constructor() : Mapper<PostDto, Post> {
    override fun map(input: PostDto): Post {
        return with(input) {
            Post(
                id = id.toString(),
                body = body,
                title = title,
                user = userId.toString(),
            )
        }
    }
}