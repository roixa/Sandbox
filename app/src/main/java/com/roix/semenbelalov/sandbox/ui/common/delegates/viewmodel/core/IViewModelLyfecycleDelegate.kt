package com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.core

import android.app.Application

interface IViewModelLyfecycleDelegate {
    fun onBindView(application: Application)
    fun onBindFirstView()
    fun onBindFirstView(application: Application)
}