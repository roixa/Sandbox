package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message

import android.content.Context
import android.widget.Toast
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

class ShowMessageDelegate : IShowMessageDelegate {

    private lateinit var context: Context

    override fun initShowMessageHandle(c: Context, subscription: ILiveDataSubscriptionDelegate, source: IShowMessageHandleViewModelDelegate) {
        context = c
        subscription.apply {
            source.showMessageLiveData.sub {
                showMessage(it)
            }
        }

    }

    override fun showMessage(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
}