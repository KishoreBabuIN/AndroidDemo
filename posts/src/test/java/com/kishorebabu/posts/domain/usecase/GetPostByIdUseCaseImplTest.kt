package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.repository.PostRepository
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

internal class GetPostByIdUseCaseImplTest {
    private val mockRepository = mock<PostRepository>()
    private val sut = GetPostByIdUseCaseImpl(mockRepository)

    @Test
    fun `invoke should return the same post when repository returns a post`() {
        val fakePostId = UUID.randomUUID().toString()
        val mockPost = mock<Post> {
            on { id } doReturn fakePostId
        }
        whenever(mockRepository.getPostById(fakePostId)).thenReturn(
            Single.just(
                SimpleResult.success(
                    mockPost
                )
            )
        )

        sut.invoke(fakePostId).test().assertValue(SimpleResult.success(mockPost))
    }

    @Test
    fun `invoke should return the same exception when repository returns an exception`() {
        val fakeThrowable = Throwable()
        whenever(mockRepository.getPostById(any())).thenReturn(
            Single.just(
                SimpleResult.failure(
                    fakeThrowable
                )
            )
        )

        sut.invoke("test").test().assertValue(SimpleResult.failure(fakeThrowable))
    }
}