package com.roix.semenbelalov.common.ui.delegates.vvm.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.BackScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.BackToScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.ForwardScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.ScreenCommand
import com.roix.semenbelalov.common.utils.ui.singleEvent

class ViewModelNavigationDelegate : IViewModelNavigationDelegate {

    private val navigation = MutableLiveData<ScreenCommand>()

    override fun getNavigationLiveData(): LiveData<ScreenCommand> = navigation

    override fun nextScreen(screenId: Int) {
        navigation.singleEvent(ScreenCommand(screenId, null))
    }

    override fun nextScreen(screenId: Int, params: Any) {
        navigation.singleEvent(ScreenCommand(screenId, params))
    }

    override fun goForward() {
        navigation.singleEvent(ForwardScreenCommand())
    }

    override fun goBack() {
        navigation.singleEvent(BackScreenCommand())
    }

    override fun backTo(screenId: Int) {
        navigation.singleEvent(BackToScreenCommand(screenId))
    }
}