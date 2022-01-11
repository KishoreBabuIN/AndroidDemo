package com.kishorebabu.gorillaschallenge.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kishorebabu.gorillaschallenge.ui.UiState
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.model.PostWithUser
import com.kishorebabu.posts.domain.usecase.GetPostWithUserDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val getPostWithUserDetailsUseCase: GetPostWithUserDetailsUseCase
) : ViewModel() {
    private val uiStateLiveData = MutableLiveData<UiState<PostWithUser>>()
    val uiState: LiveData<UiState<PostWithUser>> = uiStateLiveData


    fun onPostDetails(post: Post) {
        getPostWithUserDetailsUseCase
            .invoke(post.id, post.user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.fold(
                        success = {
                            uiStateLiveData.postValue(UiState.Content(it))
                        }, failure = {
                            uiStateLiveData.postValue(UiState.Error(it))
                        }
                    )
                },
                {
                    uiStateLiveData.postValue(UiState.Error(it))
                }
            )
    }
}