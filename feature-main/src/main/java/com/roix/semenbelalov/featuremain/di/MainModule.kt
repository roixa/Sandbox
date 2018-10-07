package com.roix.semenbelalov.featuremain.di

import com.roix.semenbelalov.featuremain.buissness.IMainInteractor
import com.roix.semenbelalov.featuremain.buissness.MainInteractor
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class MainModule : Module() {
    init {
        bind(IMainInteractor::class.java).to(MainInteractor::class.java).instancesInScope()
    }
}