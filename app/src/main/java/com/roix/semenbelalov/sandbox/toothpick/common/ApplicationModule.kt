package com.roix.semenbelalov.sandbox.toothpick.common

import android.content.Context
import com.roix.semenbelalov.common.utils.rx.general.RxSchedulers
import com.roix.semenbelalov.common.utils.rx.general.RxSchedulersAbs
import com.roix.semenbelalov.sandbox.application.CommonApplication
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class ApplicationModule(application: CommonApplication, cicerone: Cicerone<Router>) : Module() {
    init {
        bind(Context::class.java).toInstance(application.applicationContext)
        bind(RxSchedulersAbs::class.java).toInstance(RxSchedulers())
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
        bind(Router::class.java).toInstance(cicerone.router)
    }
}