package com.kishorebabu.gorillaschallenge.domain.repository

import com.kishorebabu.gorillaschallenge.domain.model.Post

interface PostRepository {
    fun getAllPosts(): List<Post>
    fun getPostById(id: String): Post?
}