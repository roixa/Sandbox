package com.roix.semenbelalov.featuredetails.di

import com.roix.semenbelalov.featuredetails.buissness.DetailsInteractor
import com.roix.semenbelalov.featuredetails.buissness.IDetailsInteractor
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class DetailsModule : Module() {
    init {
        bind(IDetailsInteractor::class.java).to(DetailsInteractor::class.java).instancesInScope()
    }
}