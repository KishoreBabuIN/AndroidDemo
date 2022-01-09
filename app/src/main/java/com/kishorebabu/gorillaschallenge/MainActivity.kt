package com.kishorebabu.gorillaschallenge

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kishorebabu.gorillaschallenge.data.network.api.JsonPlaceholderApi
import com.kishorebabu.gorillaschallenge.domain.repository.PostRepository
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var postRepo: PostRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postRepo
            .getAllPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("asdf", "Response: ${it.size}")
                },
                {
                    Log.e("asdf", "Failed", it)
                }
            )
    }
}