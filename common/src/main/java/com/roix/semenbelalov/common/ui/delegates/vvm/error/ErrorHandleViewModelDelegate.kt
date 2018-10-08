package com.roix.semenbelalov.common.ui.delegates.vvm.error

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ErrorHandleViewModelDelegate : IErrorHandleViewModelDelegate {

    val error = MutableLiveData<Throwable>()

    override fun handleError(errorThrowable: Throwable) {
        error.value = errorThrowable
    }

    override fun getErrorLiveData(): LiveData<Throwable> = error
}