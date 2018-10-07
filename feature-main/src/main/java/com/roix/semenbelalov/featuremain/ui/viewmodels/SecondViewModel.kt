package com.roix.semenbelalov.featuremain.ui.viewmodels

import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import com.roix.semenbelalov.featuremain.buissness.ISecondInteractor
import com.roix.semenbelalov.featuremain.di.SecondModule
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class SecondViewModel : BaseLifecycleViewModel() {

    @Inject
    protected lateinit var interactor: ISecondInteractor

    override fun getModule(): Module = SecondModule()
}
