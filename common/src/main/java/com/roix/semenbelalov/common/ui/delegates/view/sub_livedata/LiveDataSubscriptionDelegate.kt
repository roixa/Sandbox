package com.roix.semenbelalov.common.ui.delegates.view.sub_livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.lang.ref.WeakReference

class LiveDataSubscriptionDelegate : ILiveDataSubscriptionDelegate {

    var lifecycleOwnerWeakReference = WeakReference<LifecycleOwner>(null)

    override fun initLiveDataSubscription(livecycleOwner: LifecycleOwner) {
        lifecycleOwnerWeakReference = WeakReference(livecycleOwner)
    }

    override fun <T> LiveData<T>.sub(func: (T) -> Unit) {
        lifecycleOwnerWeakReference.get()?.let {
            observe(it, Observer { T -> if (T != null) func.invoke(T) })
        }
    }
}