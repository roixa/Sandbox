package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.IErrorHandleViewModelDelegate

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