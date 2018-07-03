package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import android.content.Context
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.IErrorHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.IShowMessageHandleViewModelDelegate

interface IShowMessageDelegate {
    fun initShowMessageHandle(context: Context, subscription: ILiveDataSubscriptionDelegate, source: IShowMessageHandleViewModelDelegate)
    fun showMessage(text: String)
}