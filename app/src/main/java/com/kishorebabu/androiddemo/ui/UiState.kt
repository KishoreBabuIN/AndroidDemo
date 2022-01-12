package com.kishorebabu.androiddemo.ui

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    class Content<T>(val data: T) : UiState<T>()
    class Error(val throwable: Throwable) : UiState<Nothing>()
}