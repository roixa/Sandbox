package com.roix.semenbelalov.common.ui.delegates.viewmodel.core

import android.app.Application

class ViewModelInitDelegate : IViewModelInitDelegate {

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