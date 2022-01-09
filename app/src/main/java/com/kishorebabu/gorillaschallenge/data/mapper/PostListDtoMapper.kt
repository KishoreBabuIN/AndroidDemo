package com.kishorebabu.gorillaschallenge.data.mapper

import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import com.kishorebabu.gorillaschallenge.domain.model.Post
import com.kishorebabu.gorillaschallenge.utils.ListMapper
import com.kishorebabu.gorillaschallenge.utils.Mapper
import javax.inject.Inject

internal class PostListDtoMapper @Inject constructor(
    private val postMapper: Mapper<PostDto, Post>
) : ListMapper<PostDto, Post> {
    override fun map(input: List<PostDto>): List<Post> = input.map { postMapper.map(it) }
}