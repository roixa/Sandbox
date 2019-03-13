package com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class LiveDataSubscriptionDelegate : ILiveDataSubscriptionDelegate {

    lateinit var lifecycleOwner: LifecycleOwner

    override fun initLiveDataSubscription(lo: LifecycleOwner) {
        lifecycleOwner = lo
    }

    override fun <T> LiveData<T>.sub(func: (T) -> Unit) {
        if (::lifecycleOwner.isInitialized) {
            observe(lifecycleOwner, Observer { T -> if (T != null) func.invoke(T) })
        }
    }
}