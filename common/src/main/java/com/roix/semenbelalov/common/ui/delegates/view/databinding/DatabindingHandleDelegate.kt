package com.roix.semenbelalov.common.ui.delegates.view.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.roix.semenbelalov.common.BR
import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import java.lang.ref.WeakReference

class DatabindingHandleDelegate<out DataBinding : ViewDataBinding, ViewModel : BaseLifecycleViewModel> : IDatabindingHandleDelegate<DataBinding, ViewModel> {

    private lateinit var bindingWeakReference: WeakReference<DataBinding>

    override fun initBinding(activity: AppCompatActivity, layoutId: Int, viewmodel: ViewModel?): DataBinding {
        val binding = DataBindingUtil.setContentView<DataBinding>(activity, layoutId)
        binding.setVariable(BR.viewmodel, viewmodel)
        binding.setLifecycleOwner(activity)
        bindingWeakReference = WeakReference(binding)
//        setupBinding()
        return binding
    }

    override fun initBinding(activity: AppCompatActivity, layoutId: Int, inflater: LayoutInflater, container: ViewGroup?, viewmodel: ViewModel?): DataBinding {
        val binding = DataBindingUtil.inflate<DataBinding>(inflater, layoutId, container, false)
        binding.setVariable(BR.viewmodel, viewmodel)
        binding.setLifecycleOwner(activity)
        bindingWeakReference = WeakReference(binding)
//        setupBinding()
        return binding
    }

    override fun getBinding(): DataBinding? = bindingWeakReference.get()

}