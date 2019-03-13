package com.roix.semenbelalov.sandbox.di.app

import android.content.Context
import com.roix.semenbelalov.sandbox.application.CommonApplication
import com.roix.semenbelalov.sandbox.utils.rx.general.RxSchedulers
import com.roix.semenbelalov.sandbox.utils.rx.general.RxSchedulersAbs
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class ApplicationModule(application: CommonApplication) : Module() {
    init {
        bind(Context::class.java).toInstance(application.applicationContext)
        bind(RxSchedulersAbs::class.java).toInstance(RxSchedulers())
    }
}