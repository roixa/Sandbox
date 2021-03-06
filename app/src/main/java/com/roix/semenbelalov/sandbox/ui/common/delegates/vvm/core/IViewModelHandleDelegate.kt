package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

interface IViewModelHandleDelegate< ViewModelType : ViewModel> {
    fun initViewModel(activity: AppCompatActivity, clazz: Class<ViewModelType>)
    var viewModel: ViewModelType
}