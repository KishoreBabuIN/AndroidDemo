package com.kishorebabu.core

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class NetworkResultMapperImpl : NetworkResultMapper {
    override fun <T : Any> map(single: Single<T>): Single<SimpleResult<T>> {
        return single.subscribeOn(Schedulers.io())
            .map { mapSuccess(it) }
            .onErrorResumeNext { mapFailure(it) }
    }

    private fun <T> mapSuccess(t: T): SimpleResult<T> {
        return Result.Success(t)
    }

    private fun <T> mapFailure(throwable: Throwable): Single<SimpleResult<T>> {
        return Single.just(Result.Failure(throwable))
    }
}