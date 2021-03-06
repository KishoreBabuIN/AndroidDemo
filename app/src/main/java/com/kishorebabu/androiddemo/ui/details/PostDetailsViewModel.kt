package com.kishorebabu.androiddemo.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kishorebabu.androiddemo.ui.UiState
import com.kishorebabu.posts.domain.model.Post
import com.kishorebabu.posts.domain.model.PostWithUser
import com.kishorebabu.posts.domain.usecase.GetUserByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
) : ViewModel() {
    private val uiStateLiveData = MutableLiveData<UiState<PostWithUser>>()
    val uiState: LiveData<UiState<PostWithUser>> = uiStateLiveData


    fun onPostDetails(post: Post) {
        getUserByIdUseCase
            .invoke(post.user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.fold(
                        success = { user ->
                            val postWithUser = PostWithUser(
                                id = post.id,
                                post = post,
                                user = user
                            )
                            uiStateLiveData.postValue(UiState.Content(postWithUser))
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

    fun retry(post: Post) {
        onPostDetails(post)
    }
}