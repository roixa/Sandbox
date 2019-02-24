package com.roix.semenbelalov.common.ui.delegates.vvm.navigation

import androidx.lifecycle.LiveData
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.ScreenCommand

interface IViewModelNavigationDelegate {
    fun getNavigationLiveData(): LiveData<ScreenCommand>

    fun nextScreen(screenId: Int)
    fun nextScreen(screenId: Int, params: Any)
    fun goForward()
    fun goBack()
    fun backTo(screenId: Int)
}