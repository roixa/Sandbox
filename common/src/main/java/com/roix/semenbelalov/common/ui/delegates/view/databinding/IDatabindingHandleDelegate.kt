package com.roix.semenbelalov.common.ui.delegates.view.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel

interface IDatabindingHandleDelegate<out DataBinding : ViewDataBinding,ViewModel : BaseLifecycleViewModel> {
    fun initBinding(activity: AppCompatActivity, layoutId: Int, viewmodel: ViewModel? = null): DataBinding
    fun initBinding(activity: AppCompatActivity, layoutId: Int, inflater: LayoutInflater, container: ViewGroup?, viewmodel: ViewModel? = null): DataBinding
    fun setupBinding()
    fun getBinding(): DataBinding?

}