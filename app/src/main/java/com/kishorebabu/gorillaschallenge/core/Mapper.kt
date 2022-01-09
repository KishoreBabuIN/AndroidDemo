package com.kishorebabu.gorillaschallenge.core

interface Mapper<I, O> {
    fun map(input: I): O
}