package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class ShowMessageHandleViewModelDelegate : IShowMessageHandleViewModelDelegate {

    val message = MutableLiveData<String>()

    override fun handleShowMessage(text: String) {
        message.value = text
    }

    override fun getShowMessageLiveData(): LiveData<String> = message
}