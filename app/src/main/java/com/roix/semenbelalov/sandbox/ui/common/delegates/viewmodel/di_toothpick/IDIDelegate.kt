package com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.di_toothpick

import android.app.Application

interface IDIDelegate {
    fun initDIDelegate(application: Application, moduleProvider: ModuleProvider)
    fun clearDiDelegate()
}