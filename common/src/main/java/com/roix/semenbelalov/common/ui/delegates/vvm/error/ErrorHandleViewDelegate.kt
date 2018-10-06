package com.roix.semenbelalov.common.ui.delegates.vvm.error

import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

class ErrorHandleViewDelegate : IErrorHandleViewDelegate {

    override fun initErrorHandle(subscription: ILiveDataSubscriptionDelegate, errorSource: IErrorHandleViewModelDelegate) {
        subscription.apply {
            errorSource.getErrorLiveData().sub {
                handleError(it)
            }
        }
    }

    override fun handleError(error: Throwable) {

    }
}