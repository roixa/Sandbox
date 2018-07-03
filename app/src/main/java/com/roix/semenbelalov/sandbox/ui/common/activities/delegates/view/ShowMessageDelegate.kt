package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import android.content.Context
import android.widget.Toast
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.IShowMessageHandleViewModelDelegate
import java.lang.ref.WeakReference

class ShowMessageDelegate : IShowMessageDelegate {

    lateinit var context: WeakReference<Context>

    override fun initShowMessageHandle(c: Context, subscription: ILiveDataSubscriptionDelegate, source: IShowMessageHandleViewModelDelegate) {
        context = WeakReference(c)
        subscription.apply {
            source.getShowMessageLiveData().sub {
                showMessage(it)
            }
        }

    }

    override fun showMessage(text: String) {
        Toast.makeText(context.get(), text, Toast.LENGTH_LONG).show()
    }
}