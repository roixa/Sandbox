package com.roix.semenbelalov.common.ui.delegates.view.sub_livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

interface ILiveDataSubscriptionDelegate {
    fun initLiveDataSubscription(livecycleOwner: LifecycleOwner)
    fun <T> LiveData<T>.sub(func: (T) -> Unit)
}