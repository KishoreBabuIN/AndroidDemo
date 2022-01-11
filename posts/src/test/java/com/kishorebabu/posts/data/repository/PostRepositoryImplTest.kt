package com.kishorebabu.posts.data.repository

import com.kishorebabu.core.ListMapper
import com.kishorebabu.core.Mapper
import com.kishorebabu.core.NetworkResultMapper
import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.data.network.api.JsonPlaceholderApi
import com.kishorebabu.posts.data.network.model.PostDto
import com.kishorebabu.posts.domain.model.Post
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class PostRepositoryImplTest {
    private val mockApi = mock<JsonPlaceholderApi>()
    private val mockNetworkResultMapper = mock<NetworkResultMapper>()
    private val mockMapper = mock<Mapper<PostDto, Post>>()
    private val mockListMapper = mock<ListMapper<PostDto, Post>>()
    private val sut =
        PostRepositoryImpl(mockApi, mockNetworkResultMapper, mockMapper, mockListMapper)


    @Test
    fun `getAllPosts should return all same posts when api return posts`() {
        val mockPostDtoList = listOf<PostDto>(mock(), mock())
        val mockPostList = listOf<Post>(mock(), mock())

        whenever(mockApi.getAllPosts()).thenReturn(Single.just(mockPostDtoList))
        whenever(mockListMapper.map(any<List<PostDto>>())).thenReturn(mockPostList)
        whenever(mockNetworkResultMapper.map(any<Single<List<Post>>>())).thenReturn(
            Single.just(
                SimpleResult.success(mockPostList)
            )
        )

        sut.getAllPosts().test().assertValue(SimpleResult.success(mockPostList))
    }

    @Test
    fun `getAllPosts should return the same exception when api return an exception`() {
        val fakeThrowable = Throwable()

        whenever(mockApi.getAllPosts()).thenReturn(Single.error(fakeThrowable))
        whenever(mockNetworkResultMapper.map(any<Single<List<Post>>>())).thenReturn(
            Single.just(
                SimpleResult.failure(fakeThrowable)
            )
        )

        sut.getAllPosts().test().assertValue(SimpleResult.failure(fakeThrowable))
    }

    @Test
    fun `getPostById should return the same posts when api return a post`() {
        val fakePostId = UUID.randomUUID().toString()
        val mockPostDto = mock<PostDto>()
        val mockPost = mock<Post>()

        whenever(mockApi.getPostById(fakePostId)).thenReturn(Single.just(mockPostDto))
        whenever(mockMapper.map(any<PostDto>())).thenReturn(mockPost)
        whenever(mockNetworkResultMapper.map(any<Single<Post>>())).thenReturn(
            Single.just(
                SimpleResult.success(mockPost)
            )
        )

        sut.getPostById(fakePostId).test().assertValue(SimpleResult.success(mockPost))
    }

    @Test
    fun `getPostById should return the same exception when api return an exception`() {
        val fakePostId = UUID.randomUUID().toString()
        val fakeThrowable = Throwable()

        whenever(mockApi.getPostById(fakePostId)).thenReturn(Single.error(fakeThrowable))
        whenever(mockNetworkResultMapper.map(any<Single<Post>>())).thenReturn(
            Single.just(
                SimpleResult.failure(fakeThrowable)
            )
        )

        sut.getPostById(fakePostId).test().assertValue(SimpleResult.failure(fakeThrowable))
    }
}