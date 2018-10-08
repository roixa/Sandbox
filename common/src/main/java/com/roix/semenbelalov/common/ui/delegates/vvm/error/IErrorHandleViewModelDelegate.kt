package com.roix.semenbelalov.common.ui.delegates.vvm.error

import androidx.lifecycle.LiveData

interface IErrorHandleViewModelDelegate {
    fun handleError(error: Throwable)
    fun getErrorLiveData(): LiveData<Throwable>

}