package com.roix.semenbelalov.sandbox.ui.common.activities.delegates

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.roix.semenbelalov.sandbox.BR

class DatabindingDelegate<out DataBinding : ViewDataBinding> : IDatabindingDelegate<DataBinding> {

    override fun initBinding(activity: AppCompatActivity, layoutId: Int, viewmodel: Any?): DataBinding {
        val binding = DataBindingUtil.setContentView<DataBinding>(activity, layoutId)
        binding.setVariable(BR.viewmodel, viewmodel)
        binding.setLifecycleOwner(activity)
        return binding
    }

    override fun initBinding(activity: AppCompatActivity, layoutId: Int, inflater: LayoutInflater, container: ViewGroup?, viewmodel: Any?): DataBinding {
        val binding = DataBindingUtil.inflate<DataBinding>(inflater, layoutId, container, false)
        binding.setVariable(BR.viewmodel, viewmodel)
        binding.setLifecycleOwner(activity)
        return binding
    }


}