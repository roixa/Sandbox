package com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.core

import android.app.Application

class ViewModelLifecycleDelegate : IViewModelLyfecycleDelegate {

    private var viewsCount = 0

    override fun onBindView(application: Application) {
        if (viewsCount == 0) {
            onBindFirstView(application)
        }
        viewsCount++
    }

    override fun onBindFirstView() {

    }

    override fun onBindFirstView(application: Application) {
        onBindFirstView()
    }
}