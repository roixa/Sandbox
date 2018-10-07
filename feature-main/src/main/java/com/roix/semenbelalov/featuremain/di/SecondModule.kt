package com.roix.semenbelalov.featuremain.di

import com.roix.semenbelalov.featuremain.buissness.ISecondInteractor
import com.roix.semenbelalov.featuremain.buissness.SecondInteractor
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class SecondModule : Module() {
    init {
        bind(ISecondInteractor::class.java).to(SecondInteractor::class.java).instancesInScope()
    }
}