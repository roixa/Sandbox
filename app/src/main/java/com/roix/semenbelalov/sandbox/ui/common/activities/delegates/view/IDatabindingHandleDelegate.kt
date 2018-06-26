package com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view

import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup

interface IDatabindingHandleDelegate<out DataBinding : ViewDataBinding> {
    fun initBinding(activity: AppCompatActivity,layoutId: Int, viewmodel: Any? = null): DataBinding
    fun initBinding(activity: AppCompatActivity, layoutId: Int, inflater: LayoutInflater, container: ViewGroup?, viewmodel: Any? = null): DataBinding
    fun getBinding(): DataBinding?
}