package com.roix.semenbelalov.common.ui.delegates.view.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

interface IDatabindingHandleDelegate<out DataBinding : ViewDataBinding> {
    fun initBinding(activity: AppCompatActivity, layoutId: Int, viewmodel: Any? = null): DataBinding
    fun initBinding(activity: AppCompatActivity, layoutId: Int, inflater: LayoutInflater, container: ViewGroup?, viewmodel: Any? = null): DataBinding
    fun setupBinding()
    fun getBinding(): DataBinding?

}