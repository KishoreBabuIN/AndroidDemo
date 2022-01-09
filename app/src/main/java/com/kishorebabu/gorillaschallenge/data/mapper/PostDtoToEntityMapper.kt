package com.kishorebabu.gorillaschallenge.data.mapper

import com.kishorebabu.gorillaschallenge.core.Mapper
import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import com.kishorebabu.gorillaschallenge.domain.model.Post
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