package com.kishorebabu.core

import io.reactivex.rxjava3.core.Single

sealed class Result<out T, out E> {
    data class Success<out T>(val value: T) : Result<T, Nothing>()
    data class Failure<out E>(val error: E) : Result<Nothing, E>()

    inline fun <C> fold(success: (T) -> C, failure: (E) -> C): C = when (this) {
        is Failure -> failure(error)
        is Success -> success(value)
    }

    companion object {
        fun <L> success(value: L): Result<L, Nothing> = Success(value)
        fun <R> failure(error: R): Result<Nothing, R> = Failure(error)
    }
}

typealias SimpleResult<T> = Result<T, Throwable>

fun <T : Any> Single<T>.mapToResult(networkResultMapper: NetworkResultMapper): Single<SimpleResult<T>> {
    return networkResultMapper.map(this)
}