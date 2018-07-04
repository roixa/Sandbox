package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading

import android.arch.lifecycle.LiveData
import com.roix.semenbelalov.sandbox.ui.common.loading.LoadingLiveData

class LoadingViewModelDelegate : ILoadingViewModelDelegate {

    private val loadingLiveData: LoadingLiveData = LoadingLiveData()

    override fun onStartLoad() = loadingLiveData.onStartLoad()

    override fun onEndLoad() = loadingLiveData.onEndLoad()

    override fun getLoadingLiveData(): LiveData<Boolean> = loadingLiveData
}