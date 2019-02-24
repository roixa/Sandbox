package com.roix.semenbelalov.featuremain.ui.viewmodels

import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import com.roix.semenbelalov.featuremain.R
import com.roix.semenbelalov.featuremain.buissness.FirstInteractor
import com.roix.semenbelalov.featuremain.di.FirstModule
import toothpick.config.Module
import javax.inject.Inject

class FirstViewModel : BaseLifecycleViewModel() {

    @Inject
    protected lateinit var firstInteractor: FirstInteractor

    override fun getModule(): Module = FirstModule()

    fun onButtonClicked() {
        nextScreen(R.id.secondFragment)
    }
}
