package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData

interface ILiveDataSubscriptionDelegate {
    fun initLiveDataSubscription(livecycleOwner: LifecycleOwner)
    fun <T> LiveData<T>.sub(func: (T) -> Unit)
}