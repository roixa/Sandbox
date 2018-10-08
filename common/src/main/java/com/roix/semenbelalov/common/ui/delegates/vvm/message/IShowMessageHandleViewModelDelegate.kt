package com.roix.semenbelalov.common.ui.delegates.vvm.message

import androidx.lifecycle.LiveData

interface IShowMessageHandleViewModelDelegate {
    fun handleShowMessage(text: String)
    fun getShowMessageLiveData(): LiveData<String>
}