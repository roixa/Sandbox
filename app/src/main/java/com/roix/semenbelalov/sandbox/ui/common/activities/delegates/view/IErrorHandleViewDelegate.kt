package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.IErrorHandleViewModelDelegate

interface IErrorHandleViewDelegate {
    fun initErrorHandle(subscription: ILiveDataSubscriptionDelegate, errorSource: IErrorHandleViewModelDelegate)
    fun handleError(error:Throwable)
}