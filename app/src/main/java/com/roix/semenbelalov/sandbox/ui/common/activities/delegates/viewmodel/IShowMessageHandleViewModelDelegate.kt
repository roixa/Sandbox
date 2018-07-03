package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel

import android.arch.lifecycle.LiveData

interface IShowMessageHandleViewModelDelegate {
    fun handleShowMessage(text: String)
    fun getShowMessageLiveData(): LiveData<String>
}