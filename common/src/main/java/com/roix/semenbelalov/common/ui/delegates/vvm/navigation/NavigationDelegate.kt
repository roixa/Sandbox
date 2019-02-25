package com.roix.semenbelalov.common.ui.delegates.vvm.navigation

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.BackScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.BackToScreenCommand
import com.roix.semenbelalov.common.ui.delegates.vvm.navigation.commands.ForwardScreenCommand

class NavigationDelegate : INavigationDelegate {

    lateinit var navController: NavController

    override fun initNavigationHandle(view: View, subscription: ILiveDataSubscriptionDelegate, source: IViewModelNavigationDelegate) {
        navController = Navigation.findNavController(view)
        subscription.apply {
            source.navigationLiveData.sub {
                when (it) {
                    is ForwardScreenCommand -> goForward()
                    is BackScreenCommand -> goBack()
                    is BackToScreenCommand -> backTo(it.screenId)
                    else -> nextScreen(it.screenId, it.params)
                }
            }
        }
    }

    override fun nextScreen(screenId: Int, params: Any?) {
        navController.navigate(screenId)
    }

    override fun goForward() {
        navController.navigateUp()
    }

    override fun goBack() {
        navController.popBackStack()
    }

    override fun backTo(screenId: Int) {
        navController.popBackStack(screenId, true)//TODO inclusive question
    }
}