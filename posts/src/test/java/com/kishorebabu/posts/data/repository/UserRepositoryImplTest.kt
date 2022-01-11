package com.kishorebabu.posts.data.repository

import com.kishorebabu.core.Mapper
import com.kishorebabu.core.NetworkResultMapper
import com.kishorebabu.core.SimpleResult
import com.kishorebabu.posts.data.network.api.JsonPlaceholderApi
import com.kishorebabu.posts.data.network.model.UserDto
import com.kishorebabu.posts.domain.model.User
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class UserRepositoryImplTest {
    private val mockApi = mock<JsonPlaceholderApi>()
    private val mockNetworkResultMapper = mock<NetworkResultMapper>()
    private val mockMapper = mock<Mapper<UserDto, User>>()
    private val sut =
        UserRepositoryImpl(mockApi, mockMapper, mockNetworkResultMapper)


    @Test
    fun `getUserById should return the same user when api returns a user`() {
        val fakeUserId = UUID.randomUUID().toString()
        val mockUserDto = mock<UserDto>()
        val mockUser = mock<User>()

        whenever(mockApi.getUserById(fakeUserId)).thenReturn(Single.just(mockUserDto))
        whenever(mockMapper.map(any<UserDto>())).thenReturn(mockUser)
        whenever(mockNetworkResultMapper.map(any<Single<User>>())).thenReturn(
            Single.just(
                SimpleResult.success(mockUser)
            )
        )

        sut.getUserById(fakeUserId).test().assertValue(SimpleResult.success(mockUser))
    }

    @Test
    fun `getUserById should return the same exception when api returns an exception`() {
        val fakeThrowable = Throwable()
        val fakeUserId = UUID.randomUUID().toString()

        whenever(mockApi.getUserById(fakeUserId)).thenReturn(Single.error(fakeThrowable))
        whenever(mockNetworkResultMapper.map(any<Single<User>>())).thenReturn(
            Single.just(
                SimpleResult.failure(fakeThrowable)
            )
        )

        sut.getUserById(fakeUserId).test().assertValue(SimpleResult.failure(fakeThrowable))
    }
}