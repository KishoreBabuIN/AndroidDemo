package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.repository.PostRepository
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class GetAllPostsUseCaseImplTest {
    private val mockRepository = mock<PostRepository>()
    private val sut = GetAllPostsUseCaseImpl(mockRepository)

    @Test
    fun `invoke should return posts when repo return posts`() {
        val mockPostList = mock<List<Post>>()
        whenever(mockRepository.getAllPosts()).thenReturn(
            Single.just(
                SimpleResult.success(
                    mockPostList
                )
            )
        )

        sut.invoke().test().assertResult(SimpleResult.success(mockPostList))
    }

    @Test
    fun `invoke should return exception when repo return exception`() {
        val fakeThrowable = Throwable()
        whenever(mockRepository.getAllPosts()).thenReturn(
            Single.just(
                SimpleResult.failure(
                    fakeThrowable
                )
            )
        )

        sut.invoke().test().assertResult(SimpleResult.failure(fakeThrowable))
    }
}