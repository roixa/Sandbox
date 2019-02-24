package com.roix.semenbelalov.common.ui.delegates.vvm.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ShowMessageHandleViewModelDelegate : IShowMessageHandleViewModelDelegate {

    private val message = MutableLiveData<String>()

    override fun handleShowMessage(text: String) {
        message.value = text
    }

    override fun getShowMessageLiveData(): LiveData<String> = message
}