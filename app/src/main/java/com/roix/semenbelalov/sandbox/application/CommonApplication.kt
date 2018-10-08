package com.roix.semenbelalov.sandbox.application

import android.app.Application
import com.roix.semenbelalov.sandbox.BuildConfig
import com.roix.semenbelalov.sandbox.FactoryRegistry
import com.roix.semenbelalov.sandbox.MemberInjectorRegistry
import com.roix.semenbelalov.sandbox.toothpick.common.ApplicationModule
import com.roix.semenbelalov.sandbox.toothpick.common.ApplicationScope
import ru.terrakok.cicerone.Cicerone
import toothpick.Toothpick
import toothpick.Toothpick.setConfiguration
import toothpick.configuration.Configuration.forDevelopment
import toothpick.configuration.Configuration.forProduction
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator


/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
class CommonApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        val configuration = if (BuildConfig.DEBUG) forDevelopment() else forProduction()
        setConfiguration(configuration.disableReflection())
        FactoryRegistryLocator.setRootRegistry(FactoryRegistry())
        MemberInjectorRegistryLocator.setRootRegistry(MemberInjectorRegistry())

        val appScope = Toothpick.openScope(this)
        appScope.installModules(ApplicationModule(this, Cicerone.create()))
        appScope.bindScopeAnnotation(ApplicationScope::class.java)
    }
}