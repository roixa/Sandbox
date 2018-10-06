package com.roix.semenbelalov.common.ui.delegates.view.sub_livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData

interface ILiveDataSubscriptionDelegate {
    fun initLiveDataSubscription(livecycleOwner: LifecycleOwner)
    fun <T> LiveData<T>.sub(func: (T) -> Unit)
}