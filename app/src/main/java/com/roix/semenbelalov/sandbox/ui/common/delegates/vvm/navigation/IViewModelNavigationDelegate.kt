package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.navigation

import androidx.lifecycle.LiveData
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.navigation.commands.ScreenCommand

interface IViewModelNavigationDelegate {
    val navigationLiveData: LiveData<ScreenCommand>

    fun nextScreen(screenId: Int)
    fun nextScreen(screenId: Int, params: Any)
    fun goForward()
    fun goBack()
    fun backTo(screenId: Int)
}