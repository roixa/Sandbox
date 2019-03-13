package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading

import androidx.lifecycle.LiveData

interface ILoadingViewModelDelegate {
    fun onStartLoad()
    fun onEndLoad()
    val loadingLiveData: LiveData<Boolean>
}