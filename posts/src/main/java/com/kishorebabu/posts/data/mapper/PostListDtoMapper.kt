package com.kishorebabu.posts.data.mapper

import com.kishorebabu.core.ListMapper
import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.model.PostDto
import com.kishorebabu.posts.domain.model.Post
import javax.inject.Inject

internal class PostListDtoMapper @Inject constructor(
    private val postMapper: Mapper<PostDto, Post>
) : ListMapper<PostDto, Post> {
    override fun map(input: List<PostDto>): List<Post> = input.map { postMapper.map(it) }
}