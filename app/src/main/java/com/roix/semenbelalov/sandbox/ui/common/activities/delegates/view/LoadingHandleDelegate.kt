package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.ILoadingViewModelDelegate

class LoadingHandleDelegate:ILoadingHandleDelegate {

    override fun initLoadingHandle(subscription: ILiveDataSubscriptionDelegate, source: ILoadingViewModelDelegate) {
        subscription.apply {
            source.getLoadingLiveData().sub {
                handleProgress(it)
            }
        }

    }

    override fun handleProgress(isProgress: Boolean) {
    }
}