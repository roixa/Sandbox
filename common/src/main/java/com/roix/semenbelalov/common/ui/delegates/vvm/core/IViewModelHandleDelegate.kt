package com.roix.semenbelalov.common.ui.delegates.vvm.core

import android.arch.lifecycle.ViewModel
import android.support.v7.app.AppCompatActivity

interface IViewModelHandleDelegate< ViewModelType : ViewModel> {
    fun initViewModel(activity: AppCompatActivity, clazz: Class<ViewModelType>)
    fun getViewModel(): ViewModelType

}