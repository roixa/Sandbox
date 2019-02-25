package com.roix.semenbelalov.common.ui.delegates.vvm.error

import androidx.lifecycle.MutableLiveData

class ErrorHandleViewModelDelegate : IErrorHandleViewModelDelegate {

    override val errorLiveData = MutableLiveData<Throwable>()

    override fun handleError(errorThrowable: Throwable) {
        errorLiveData.value = errorThrowable
    }

}