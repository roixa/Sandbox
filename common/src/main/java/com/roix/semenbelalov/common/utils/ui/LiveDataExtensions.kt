package com.roix.semenbelalov.common.utils.ui

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.singleEvent(param: T) {
    value = param
    value = null
}
