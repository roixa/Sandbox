package com.roix.semenbelalov.sandbox.di.splash

import com.roix.semenbelalov.sandbox.buissness.splash.ISplashInteractor
import com.roix.semenbelalov.sandbox.buissness.splash.SplashInteractor
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class SplashModule : Module() {
    init {
        bind(ISplashInteractor::class.java).to(SplashInteractor::class.java).instancesInScope()
    }
}