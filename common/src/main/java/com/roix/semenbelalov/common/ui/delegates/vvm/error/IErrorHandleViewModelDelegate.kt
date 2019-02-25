package com.roix.semenbelalov.common.ui.delegates.vvm.error

import androidx.lifecycle.LiveData

interface IErrorHandleViewModelDelegate {
    fun handleError(error: Throwable)
    val errorLiveData: LiveData<Throwable>

}