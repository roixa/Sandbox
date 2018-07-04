package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core

import android.arch.lifecycle.ViewModel
import android.support.v4.app.FragmentActivity

interface IViewModelHandleDelegate<out ViewModelType : ViewModel> {
    fun initViewModel(activity: FragmentActivity)
    fun getViewModel(): ViewModelType
}