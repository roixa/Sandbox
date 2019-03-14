package com.roix.semenbelalov.sandbox.di.main

import com.roix.semenbelalov.sandbox.buissness.main.IMainInteractor
import com.roix.semenbelalov.sandbox.buissness.main.MainInteractor
import com.roix.semenbelalov.sandbox.data.repositories.main.IMainRepository
import com.roix.semenbelalov.sandbox.data.repositories.main.MainRepository
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class MainModule : Module() {
    init {
        bind(IMainInteractor::class.java).to(MainInteractor::class.java).instancesInScope()
        bind(IMainRepository::class.java).to(MainRepository::class.java).instancesInScope()
    }
}