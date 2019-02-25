package com.roix.semenbelalov.common.ui.delegates.viewmodel.di_toothpick

import android.app.Application
import toothpick.Scope
import toothpick.Toothpick

class DIToothpickDelegate : IDIDelegate {

    lateinit var viewModelScope: Scope

    override fun initDIDelegate(application: Application, moduleProvider: ModuleProvider) {
        viewModelScope = Toothpick.openScopes(application, this)
        viewModelScope.installModules(moduleProvider.getModule())
        Toothpick.inject(this, viewModelScope)
    }

    override fun clearDiDelegate() {
        if (::viewModelScope.isInitialized) {
            Toothpick.closeScope(viewModelScope)
        }
    }
}