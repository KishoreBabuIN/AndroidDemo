package com.kishorebabu.gorillaschallenge.data.repository

import com.kishorebabu.gorillaschallenge.data.network.api.JsonPlaceholderApi
import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import com.kishorebabu.gorillaschallenge.domain.model.Post
import com.kishorebabu.gorillaschallenge.domain.repository.PostRepository
import com.kishorebabu.gorillaschallenge.utils.ListMapper
import com.kishorebabu.gorillaschallenge.utils.Mapper
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor(
    private val api: JsonPlaceholderApi,
    private val mapper: Mapper<PostDto, Post>,
    private val listMapper: ListMapper<PostDto, Post>
) : PostRepository {
    override fun getAllPosts(): Single<List<Post>> {
        return api.getAllPosts()
            .map { listMapper.map(it) }
    }

    override fun getPostById(id: String): Single<Post> {
        return api.getPostById(id)
            .map { mapper.map(it) }
    }
}