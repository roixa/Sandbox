package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error

import androidx.lifecycle.LiveData

interface IErrorHandleViewModelDelegate {
    fun handleError(error: Throwable)
    val errorLiveData: LiveData<Throwable>

}