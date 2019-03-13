package com.roix.semenbelalov.sandbox.ui.common.fragments

import android.content.Context
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.IToolbarDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.ToolbarDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.ToolbarProvider
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel

abstract class BaseToolbarFragment<ViewModel : BaseLifecycleViewModel, DataBinding : ViewDataBinding> : BaseDatabindingFragment<ViewModel, DataBinding>()
        , IToolbarDelegate by ToolbarDelegate()
        , ToolbarProvider {

    @CallSuper
    override fun setupUi() {
        super.setupUi()
        initToolbarDelegate(this, this, activity as Context)
    }


}
