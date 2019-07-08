package com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.di_toothpick

import com.roix.semenbelalov.sandbox.application.CommonApplication

interface IDIDelegate {
    fun initDIDelegate(application: CommonApplication, moduleProvider: ModuleProvider, injectingObject: Any, injectTag: Any)
    fun clearDiDelegate()
}