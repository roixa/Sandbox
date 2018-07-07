package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message

import android.content.Context
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

interface IShowMessageDelegate {
    fun initShowMessageHandle(context: Context, subscription: ILiveDataSubscriptionDelegate, source: IShowMessageHandleViewModelDelegate)
    fun showMessage(text: String)
}