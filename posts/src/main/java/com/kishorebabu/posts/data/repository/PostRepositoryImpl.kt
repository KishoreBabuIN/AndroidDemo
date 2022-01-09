package com.kishorebabu.posts.data.repository

import com.kishorebabu.core.ListMapper
import com.kishorebabu.core.Mapper
import com.kishorebabu.posts.data.network.api.JsonPlaceholderApi
import com.kishorebabu.posts.data.network.model.PostDto
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.repository.PostRepository
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