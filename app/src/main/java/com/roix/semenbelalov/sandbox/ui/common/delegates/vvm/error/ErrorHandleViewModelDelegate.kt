package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error

import androidx.lifecycle.MutableLiveData

class ErrorHandleViewModelDelegate : IErrorHandleViewModelDelegate {

    override val errorLiveData = MutableLiveData<Throwable>()

    override fun handleError(errorThrowable: Throwable) {
        errorLiveData.value = errorThrowable
    }

}