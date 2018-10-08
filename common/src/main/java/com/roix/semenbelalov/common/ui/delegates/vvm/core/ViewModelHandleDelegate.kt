package com.roix.semenbelalov.common.ui.delegates.vvm.core

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

class ViewModelHandleDelegate<ViewModelType : ViewModel> : IViewModelHandleDelegate<ViewModelType> {

    lateinit var vm: ViewModelType

    override fun initViewModel(activity: AppCompatActivity, clazz: Class<ViewModelType>) {
        vm = ViewModelProviders.of(activity).get(clazz)
    }

    override fun getViewModel(): ViewModelType = vm


}