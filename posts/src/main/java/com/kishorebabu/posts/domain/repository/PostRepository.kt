package com.kishorebabu.posts.domain.repository

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.Post
import io.reactivex.rxjava3.core.Single

interface PostRepository {
    fun getAllPosts(): Single<SimpleResult<List<Post>>>
    fun getPostById(id: String): Single<SimpleResult<Post>>
}