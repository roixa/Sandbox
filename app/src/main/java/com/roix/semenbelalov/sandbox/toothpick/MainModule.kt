package com.roix.semenbelalov.sandbox.toothpick

import com.roix.semenbelalov.sandbox.buissness.IMainInteractor
import com.roix.semenbelalov.sandbox.buissness.MainInteractor
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