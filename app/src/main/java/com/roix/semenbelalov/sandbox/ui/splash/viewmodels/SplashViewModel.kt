package com.roix.semenbelalov.sandbox.ui.splash.viewmodels

import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.buissness.splash.ISplashInteractor
import com.roix.semenbelalov.sandbox.di.splash.SplashModule
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseViewModel
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class SplashViewModel : BaseViewModel() {

    @Inject
    protected lateinit var interactor: ISplashInteractor

    override val module: Module = SplashModule()


    fun onClickedButton() {
        nextScreen(R.id.MainFragment)
    }
}
