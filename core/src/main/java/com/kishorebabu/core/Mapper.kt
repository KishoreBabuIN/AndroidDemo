package com.kishorebabu.core

interface Mapper<I, O> {
    fun map(input: I): O
}