package com.kishorebabu.posts.domain.repository

import com.kishorebabu.posts.domain.model.Post
import io.reactivex.rxjava3.core.Single

interface PostRepository {
    fun getAllPosts(): Single<List<Post>>
    fun getPostById(id: String): Single<Post>
}