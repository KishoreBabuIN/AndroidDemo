package com.kishorebabu.gorillaschallenge.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kishorebabu.gorillaschallenge.ui.UiState
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.usecase.GetAllPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PostsListViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase
) : ViewModel() {

    private val uiStateLiveData = MutableLiveData<UiState<List<Post>>>()
    val uiState: LiveData<UiState<List<Post>>> = uiStateLiveData

    fun onViewReady() {
        getAllPostsUseCase
            .invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                uiStateLiveData.postValue(UiState.Loading)
            }
            .subscribe(
                {
                    it.fold(
                        success = {
                            uiStateLiveData.postValue(UiState.Content(it))
                        }, failure = {
                            uiStateLiveData.postValue(UiState.Error(it))
                            Log.e("asdf", "Failed", it)
                        }
                    )
                },
                {
                    uiStateLiveData.postValue(UiState.Error(it))
                    Log.e("asdf", "Failed", it)
                }
            )
    }
}