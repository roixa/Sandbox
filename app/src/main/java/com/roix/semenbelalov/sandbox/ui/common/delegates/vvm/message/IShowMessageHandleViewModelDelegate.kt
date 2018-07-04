package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message

import android.arch.lifecycle.LiveData

interface IShowMessageHandleViewModelDelegate {
    fun handleShowMessage(text: String)
    fun getShowMessageLiveData(): LiveData<String>
}