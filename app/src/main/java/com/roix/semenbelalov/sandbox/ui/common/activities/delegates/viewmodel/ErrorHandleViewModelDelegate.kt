package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.*

class ErrorHandleViewModelDelegate : IErrorHandleViewModelDelegate {

    val error = MutableLiveData<Throwable>()

    override fun Observable.handleError(errorThrowable: Throwable) {
        error.value = errorThrowable
    }

    override fun getErrorLiveData(): LiveData<Throwable> = error
}