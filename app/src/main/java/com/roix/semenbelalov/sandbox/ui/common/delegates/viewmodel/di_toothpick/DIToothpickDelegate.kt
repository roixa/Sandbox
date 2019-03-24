package com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.di_toothpick

import com.roix.semenbelalov.sandbox.application.CommonApplication
import toothpick.Scope
import toothpick.Toothpick

class DIToothpickDelegate : IDIDelegate {

    private lateinit var viewModelScope: Scope

    override fun initDIDelegate(application: CommonApplication, moduleProvider: ModuleProvider, injectingObject: Any) {
        viewModelScope = Toothpick.openScopes(application, this)
        viewModelScope.installModules(moduleProvider.module)
        Toothpick.inject(injectingObject, viewModelScope)
    }

    override fun clearDiDelegate() {
        if (::viewModelScope.isInitialized) {
            Toothpick.closeScope(viewModelScope)
        }
    }
}