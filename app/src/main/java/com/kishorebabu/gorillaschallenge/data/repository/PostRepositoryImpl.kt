package com.kishorebabu.gorillaschallenge.data.repository

import com.kishorebabu.gorillaschallenge.core.ListMapper
import com.kishorebabu.gorillaschallenge.core.Mapper
import com.kishorebabu.gorillaschallenge.data.network.api.JsonPlaceholderApi
import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import com.kishorebabu.gorillaschallenge.domain.model.Post
import com.kishorebabu.gorillaschallenge.domain.repository.PostRepository
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor(
    private val api: JsonPlaceholderApi,
    private val mapper: Mapper<PostDto, Post>,
    private val listMapper: ListMapper<PostDto, Post>
) : PostRepository {
    override fun getAllPosts(): List<Post> {
        val result = api.getAllPosts().execute().body() ?: emptyList<PostDto>()
        return listMapper.map(result)
    }

    override fun getPostById(id: String): Post? {
        return api.getPostById(id).execute().body()?.let {
            mapper.map(it)
        }
    }
}