package com.roix.semenbelalov.featuremain.di

import com.roix.semenbelalov.featuremain.buissness.FirstInteractor
import com.roix.semenbelalov.featuremain.buissness.IFirstInteractor
import toothpick.config.Module

class FirstModule : Module() {
    init {
        bind(IFirstInteractor::class.java).to(FirstInteractor::class.java).instancesInScope()
    }
}