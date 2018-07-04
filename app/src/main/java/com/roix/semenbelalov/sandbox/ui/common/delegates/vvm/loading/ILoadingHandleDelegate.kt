package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading

import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core.ILiveDataSubscriptionDelegate

interface ILoadingHandleDelegate {
    fun initLoadingHandle(subscription: ILiveDataSubscriptionDelegate, source: ILoadingViewModelDelegate)
    fun handleProgress(isProgress: Boolean)

}