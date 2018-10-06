package com.roix.semenbelalov.common.ui.delegates.viewmodel.di_toothpick

import android.app.Application

interface IDIDelegate {
    fun initDIDelegate(application: Application, moduleProvider: ModuleProvider)
    fun clearDiDelegate()
}