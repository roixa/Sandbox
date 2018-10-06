package com.roix.semenbelalov.common.ui.delegates.vvm.message

import android.content.Context
import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

interface IShowMessageDelegate {
    fun initShowMessageHandle(context: Context, subscription: ILiveDataSubscriptionDelegate, source: IShowMessageHandleViewModelDelegate)
    fun showMessage(text: String)
}