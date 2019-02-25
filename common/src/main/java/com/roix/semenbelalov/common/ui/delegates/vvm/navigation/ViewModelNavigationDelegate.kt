package com.roix.semenbelalov.common.ui.delegates.vvm.navigation

import androidx.lifecycle.MutableLiveData
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.BackScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.BackToScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.ForwardScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.ScreenCommand
import com.roix.semenbelalov.common.utils.ui.singleEvent

class ViewModelNavigationDelegate : IViewModelNavigationDelegate {

    override val navigationLiveData: MutableLiveData<ScreenCommand> = MutableLiveData()

    override fun nextScreen(screenId: Int) {
        navigationLiveData.singleEvent(ScreenCommand(screenId, null))
    }

    override fun nextScreen(screenId: Int, params: Any) {
        navigationLiveData.singleEvent(ScreenCommand(screenId, params))
    }

    override fun goForward() {
        navigationLiveData.singleEvent(ForwardScreenCommand())
    }

    override fun goBack() {
        navigationLiveData.singleEvent(BackScreenCommand())
    }

    override fun backTo(screenId: Int) {
        navigationLiveData.singleEvent(BackToScreenCommand(screenId))
    }
}