package com.roix.semenbelalov.common.ui.delegates.viewmodel.di_toothpick

import android.app.Application
import toothpick.Scope
import toothpick.Toothpick
import java.lang.ref.WeakReference

class DIToothpickDelegate : IDIDelegate {

    var viewModelScope = WeakReference<Scope>(null)

    override fun initDIDelegate(application: Application, moduleProvider: ModuleProvider) {

        val scope = Toothpick.openScopes(application, this)
        scope.installModules(moduleProvider.getModule())
        Toothpick.inject(this, scope)
        viewModelScope = WeakReference(scope)
    }

    override fun clearDiDelegate() {
        viewModelScope.get()?.let {
            Toothpick.closeScope(it)
        }
    }
}