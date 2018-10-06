package com.roix.semenbelalov.common.ui.delegates.vvm.loading

import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

interface ILoadingHandleDelegate {
    fun initLoadingHandle(subscription: ILiveDataSubscriptionDelegate, source: ILoadingViewModelDelegate)
    fun handleProgress(isProgress: Boolean)

}