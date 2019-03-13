package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message

import androidx.lifecycle.LiveData

interface IShowMessageHandleViewModelDelegate {
    fun handleShowMessage(text: String)
    val showMessageLiveData: LiveData<String>
}