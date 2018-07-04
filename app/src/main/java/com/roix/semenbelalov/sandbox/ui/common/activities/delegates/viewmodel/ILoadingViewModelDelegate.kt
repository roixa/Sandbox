package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel

import android.arch.lifecycle.LiveData

interface ILoadingViewModelDelegate {
    fun onStartLoad()
    fun onEndLoad()
    fun getLoadingLiveData(): LiveData<Boolean>
}