package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error

import android.arch.lifecycle.LiveData

interface IErrorHandleViewModelDelegate {
    fun handleError(error: Throwable)
    fun getErrorLiveData(): LiveData<Throwable>

}