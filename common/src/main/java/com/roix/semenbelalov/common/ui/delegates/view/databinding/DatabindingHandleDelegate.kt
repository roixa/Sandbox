package com.roix.semenbelalov.common.ui.delegates.view.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.roix.semenbelalov.common.BR
import java.lang.ref.WeakReference

class DatabindingHandleDelegate<out DataBinding : ViewDataBinding> : IDatabindingHandleDelegate<DataBinding> {

    private lateinit var bindingWeakReference: WeakReference<DataBinding>

    override fun initBinding(activity: AppCompatActivity, layoutId: Int, viewmodel: Any?): DataBinding {
        val binding = DataBindingUtil.setContentView<DataBinding>(activity, layoutId)
        binding.setVariable(BR.viewmodel, viewmodel)
        binding.setLifecycleOwner(activity)
        bindingWeakReference = WeakReference(binding)
        return binding
    }

    override fun initBinding(activity: AppCompatActivity, layoutId: Int, inflater: LayoutInflater, container: ViewGroup?, viewmodel: Any?): DataBinding {
        val binding = DataBindingUtil.inflate<DataBinding>(inflater, layoutId, container, false)
        binding.setVariable(BR.viewmodel, viewmodel)
        binding.setLifecycleOwner(activity)
        bindingWeakReference = WeakReference(binding)
        setupBinding()
        return binding
    }

    override fun setupBinding() {

    }

    override fun getBinding(): DataBinding? = bindingWeakReference.get()

}