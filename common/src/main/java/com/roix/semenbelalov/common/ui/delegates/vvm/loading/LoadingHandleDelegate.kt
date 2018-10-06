package com.roix.semenbelalov.common.ui.delegates.vvm.loading

import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

class LoadingHandleDelegate: ILoadingHandleDelegate {

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