package com.kishorebabu.gorillaschallenge.domain.repository

import com.kishorebabu.gorillaschallenge.domain.model.Post
import io.reactivex.rxjava3.core.Single

interface PostRepository {
    fun getAllPosts(): Single<List<Post>>
    fun getPostById(id: String): Single<Post>
}