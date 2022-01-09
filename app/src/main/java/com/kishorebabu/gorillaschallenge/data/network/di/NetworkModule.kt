package com.kishorebabu.gorillaschallenge.data.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideRetrofit(): Retrofit {

        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build();
    }
}