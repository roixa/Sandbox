package com.roix.semenbelalov.common.ui.delegates.vvm.core

import android.arch.lifecycle.ViewModel
import android.support.v4.app.FragmentActivity

interface IViewModelHandleDelegate< ViewModelType : ViewModel> {
    fun initViewModel(activity: FragmentActivity, clazz: Class<ViewModelType>)
    fun getViewModel(): ViewModelType

}