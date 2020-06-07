package com.realm.example.extensions

import androidx.lifecycle.LiveData

fun <T> T.asLiveData(): LiveData<T> {
    val result = androidx.lifecycle.MutableLiveData<T>()
    result.postValue(this)
    return result
}