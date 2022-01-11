package com.kishorebabu.gorillaschallenge.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kishorebabu.posts.domain.usecase.GetAllPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PostsListViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase
) : ViewModel() {

    fun onViewReady() {
        getAllPostsUseCase
            .invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.fold(
                        success = {
                            Log.d("asdf", "Response: ${it.size}")
                        }, failure = {
                            Log.e("asdf", "Failed", it)
                        }
                    )

                },
                {
                    Log.e("asdf", "Failed", it)
                }
            )
    }
}