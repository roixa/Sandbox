package com.roix.semenbelalov.common.ui.delegates.vvm.error

import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

interface IErrorHandleViewDelegate {
    fun initErrorHandle(subscription: ILiveDataSubscriptionDelegate, errorSource: IErrorHandleViewModelDelegate)
    fun handleError(error:Throwable)
}