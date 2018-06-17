package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel

import android.arch.lifecycle.LiveData
import java.util.*

interface IErrorHandleViewModelDelegate {
    fun handleError(error: Throwable)
    fun getErrorLiveData(): LiveData<Throwable>

}