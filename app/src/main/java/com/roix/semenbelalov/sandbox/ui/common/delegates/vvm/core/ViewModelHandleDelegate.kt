package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

class ViewModelHandleDelegate<ViewModelType : ViewModel> : IViewModelHandleDelegate<ViewModelType> {

    override lateinit var viewModel: ViewModelType

    override fun initViewModel(activity: AppCompatActivity, clazz: Class<ViewModelType>) {
        viewModel = ViewModelProviders.of(activity).get(clazz)
    }


}