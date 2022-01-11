package com.kishorebabu.posts.data.repository

import com.kishorebabu.core.*
import com.kishorebabu.posts.data.network.api.JsonPlaceholderApi
import com.kishorebabu.posts.data.network.model.PostDto
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.repository.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor(
    private val api: JsonPlaceholderApi,
    private val networkResultMapper: NetworkResultMapper,
    private val mapper: Mapper<PostDto, Post>,
    private val listMapper: ListMapper<PostDto, Post>
) : PostRepository {
    override fun getAllPosts(): Single<SimpleResult<List<Post>>> {
        return api.getAllPosts()
            .map { listMapper.map(it) }
            .mapToResult(networkResultMapper)
    }

    override fun getPostById(id: String): Single<SimpleResult<Post>> {
        return api.getPostById(id)
            .map { mapper.map(it) }
            .mapToResult(networkResultMapper)
    }
}