package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel

import android.arch.lifecycle.LiveData
import java.util.*

internal interface IErrorHandleViewModelDelegate {
    fun Observable.handleError(error: Throwable)
    fun getErrorLiveData(): LiveData<Throwable>

}