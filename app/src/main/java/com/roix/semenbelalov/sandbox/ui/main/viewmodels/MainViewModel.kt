package com.roix.semenbelalov.sandbox.ui.main.viewmodels

import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import com.roix.semenbelalov.sandbox.buissness.main.IMainInteractor
import com.roix.semenbelalov.sandbox.toothpick.main.MainModule
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class MainViewModel : BaseLifecycleViewModel() {

    @Inject
    protected lateinit var mainInteractor: IMainInteractor

    override fun getModule(): Module = MainModule()
}
