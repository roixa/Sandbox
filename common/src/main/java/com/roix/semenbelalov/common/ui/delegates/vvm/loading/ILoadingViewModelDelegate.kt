package com.roix.semenbelalov.common.ui.delegates.vvm.loading

import androidx.lifecycle.LiveData

interface ILoadingViewModelDelegate {
    fun onStartLoad()
    fun onEndLoad()
    val loadingLiveData: LiveData<Boolean>
}