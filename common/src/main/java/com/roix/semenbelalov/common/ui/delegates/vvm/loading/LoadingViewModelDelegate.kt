package com.roix.semenbelalov.common.ui.delegates.vvm.loading

import com.roix.semenbelalov.common.ui.loading.LoadingLiveData

class LoadingViewModelDelegate : ILoadingViewModelDelegate {

    override val loadingLiveData: LoadingLiveData = LoadingLiveData()

    override fun onStartLoad() = loadingLiveData.onStartLoad()

    override fun onEndLoad() = loadingLiveData.onEndLoad()

}