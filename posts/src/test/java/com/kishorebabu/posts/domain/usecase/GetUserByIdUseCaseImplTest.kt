package com.kishorebabu.posts.domain.usecase

import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.domain.model.User
import com.kishorebabu.posts.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class GetUserByIdUseCaseImplTest {
    private val mockRepository = mock<UserRepository>()
    private val sut = GetUserByIdUseCaseImpl(mockRepository)

    @Test
    fun `invoke should return the same user when repository returns a user`() {
        val fakeUserId = UUID.randomUUID().toString()
        val mockUser = mock<User> {
            on { id } doReturn fakeUserId
        }
        whenever(mockRepository.getUserById(fakeUserId)).thenReturn(
            Single.just(
                SimpleResult.success(
                    mockUser
                )
            )
        )

        sut.invoke(fakeUserId).test().assertValue(SimpleResult.success(mockUser))
    }

    @Test
    fun `invoke should return the same exception when repository returns an exception`() {
        val fakeThrowable = Throwable()
        whenever(mockRepository.getUserById(any())).thenReturn(
            Single.just(
                SimpleResult.failure(
                    fakeThrowable
                )
            )
        )

        sut.invoke("test").test().assertValue(SimpleResult.failure(fakeThrowable))
    }
}