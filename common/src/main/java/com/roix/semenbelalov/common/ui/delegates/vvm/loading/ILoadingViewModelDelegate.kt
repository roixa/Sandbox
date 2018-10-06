package com.roix.semenbelalov.common.ui.delegates.vvm.loading

import android.arch.lifecycle.LiveData

interface ILoadingViewModelDelegate {
    fun onStartLoad()
    fun onEndLoad()
    fun getLoadingLiveData(): LiveData<Boolean>
}