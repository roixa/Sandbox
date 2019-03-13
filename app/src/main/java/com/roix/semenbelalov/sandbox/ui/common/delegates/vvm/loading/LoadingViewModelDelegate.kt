package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading

import com.roix.semenbelalov.sandbox.ui.common.loading.LoadingLiveData

class LoadingViewModelDelegate : ILoadingViewModelDelegate {

    override val loadingLiveData: LoadingLiveData = LoadingLiveData()

    override fun onStartLoad() = loadingLiveData.onStartLoad()

    override fun onEndLoad() = loadingLiveData.onEndLoad()

}