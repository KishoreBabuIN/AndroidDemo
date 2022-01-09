package com.kishorebabu.gorillaschallenge.utils

interface Mapper<I, O> {
    fun map(input: I): O
}