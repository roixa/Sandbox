package com.roix.semenbelalov.common.ui.delegates.view.sub_livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import java.lang.ref.WeakReference

class LiveDataSubscriptionDelegate : ILiveDataSubscriptionDelegate {

    lateinit var lifecycleOwnerWeakReference: WeakReference<LifecycleOwner>

    override fun initLiveDataSubscription(livecycleOwner: LifecycleOwner) {
        lifecycleOwnerWeakReference = WeakReference(livecycleOwner)
    }

    override fun <T> LiveData<T>.sub(func: (T) -> Unit) {
        lifecycleOwnerWeakReference.get()?.let {
            observe(it, Observer { T -> if (T != null) func.invoke(T) })
        }
    }
}