package com.roix.semenbelalov.featuredetails.ui.viewmodels

import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import com.roix.semenbelalov.featuredetails.buissness.IDetailsInteractor
import com.roix.semenbelalov.featuredetails.di.DetailsModule
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class DetailsViewModel : BaseLifecycleViewModel() {

    @Inject
    protected lateinit var interactor: IDetailsInteractor

    override fun getModule(): Module = DetailsModule()
}
