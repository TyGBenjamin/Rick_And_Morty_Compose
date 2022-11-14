package com.example.rickandmortycompose.util

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    object Loading : Resource<Nothing>()
    data class Error(val message: String) : Resource<Nothing>()
}
