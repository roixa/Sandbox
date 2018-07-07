package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity

class ViewModelHandleDelegate<ViewModelType : ViewModel> : IViewModelHandleDelegate<ViewModelType> {

    lateinit var vm: ViewModelType

    override fun initViewModel(activity: FragmentActivity, clazz: Class<ViewModelType>) {
        vm = ViewModelProviders.of(activity).get(clazz)
    }

    override fun getViewModel(): ViewModelType = vm


}