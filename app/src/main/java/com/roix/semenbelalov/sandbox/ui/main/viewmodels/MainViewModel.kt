package com.roix.semenbelalov.sandbox.ui.main.viewmodels

import com.roix.semenbelalov.sandbox.buissness.main.IMainInteractor
import com.roix.semenbelalov.sandbox.di.main.MainModule
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseViewModel
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class MainViewModel : BaseViewModel() {

    @Inject
    protected lateinit var interactor: IMainInteractor

    override val module: Module = MainModule()
}
