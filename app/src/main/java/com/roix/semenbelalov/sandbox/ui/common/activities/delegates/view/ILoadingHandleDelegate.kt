package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.IErrorHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.ILoadingViewModelDelegate

interface ILoadingHandleDelegate {
    fun initLoadingHandle(subscription: ILiveDataSubscriptionDelegate, source: ILoadingViewModelDelegate)
    fun handleProgress(isProgress: Boolean)

}