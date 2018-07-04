package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error

import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core.ILiveDataSubscriptionDelegate

interface IErrorHandleViewDelegate {
    fun initErrorHandle(subscription: ILiveDataSubscriptionDelegate, errorSource: IErrorHandleViewModelDelegate)
    fun handleError(error:Throwable)
}