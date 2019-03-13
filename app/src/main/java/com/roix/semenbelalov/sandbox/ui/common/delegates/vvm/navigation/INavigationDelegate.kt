package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.navigation

import android.view.View
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

interface INavigationDelegate {
    fun initNavigationHandle(view: View, subscription: ILiveDataSubscriptionDelegate, source: IViewModelNavigationDelegate)
    fun nextScreen(screenId: Int, params: Any?)
    fun goForward()
    fun goBack()
    fun backTo(screenId: Int)
}