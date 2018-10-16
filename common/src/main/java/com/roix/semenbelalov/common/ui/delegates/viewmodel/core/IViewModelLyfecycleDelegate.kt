package com.roix.semenbelalov.common.ui.delegates.viewmodel.core

import android.app.Application

interface IViewModelLyfecycleDelegate {
    fun onBindView(application: Application)
    fun onBindFirstView()
    fun onBindFirstView(application: Application)
}