package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import java.lang.reflect.ParameterizedType

class ViewModelHandleDelegate<ViewModelType : ViewModel> : IViewModelHandleDelegate<ViewModelType> {

    lateinit var vm: ViewModelType

    override fun initViewModel(activity: FragmentActivity) {
        vm = ViewModelProviders.of(activity).get(getViewModelJavaClass())
    }

    override fun getViewModel(): ViewModelType = vm

    private fun getViewModelJavaClass(): Class<ViewModelType> {
        return (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModelType>
    }

}