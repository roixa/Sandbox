package com.roix.semenbelalov.common.ui.delegates.vvm.message

import androidx.lifecycle.MutableLiveData

class ShowMessageHandleViewModelDelegate : IShowMessageHandleViewModelDelegate {

    override val showMessageLiveData: MutableLiveData<String> = MutableLiveData()

    override fun handleShowMessage(text: String) {
        showMessageLiveData.value = text
    }

}