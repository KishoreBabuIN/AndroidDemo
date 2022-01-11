package com.kishorebabu.core

import io.reactivex.rxjava3.core.Single

interface NetworkResultMapper {
    fun <T : Any> map(single: Single<T>): Single<SimpleResult<T>>
}