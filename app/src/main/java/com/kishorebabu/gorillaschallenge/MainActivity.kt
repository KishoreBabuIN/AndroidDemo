package com.kishorebabu.gorillaschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kishorebabu.gorillaschallenge.data.network.api.JsonPlaceholderApi
import com.kishorebabu.gorillaschallenge.data.network.model.PostDto
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit.create(JsonPlaceholderApi::class.java)
            .getAllPosts().enqueue(object : Callback<List<PostDto>> {
                override fun onResponse(
                    call: Call<List<PostDto>>,
                    response: Response<List<PostDto>>
                ) {
                    Log.d("asdf", "Response: ${response.body()?.size}")
                }

                override fun onFailure(call: Call<List<PostDto>>, t: Throwable) {
                    Log.e("asdf", "Failed", t)
                }

            })
    }
}