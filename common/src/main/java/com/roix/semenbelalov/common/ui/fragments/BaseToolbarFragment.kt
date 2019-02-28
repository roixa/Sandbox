package com.roix.semenbelalov.common.ui.fragments

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import com.roix.semenbelalov.common.ui.delegates.view.toolbar.IToolbarDelegate
import com.roix.semenbelalov.common.ui.delegates.view.toolbar.ToolbarDelegate
import com.roix.semenbelalov.common.ui.delegates.view.toolbar.ToolbarProvider
import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel

abstract class BaseToolbarFragment<ViewModel : BaseLifecycleViewModel, DataBinding : ViewDataBinding> : BaseDatabindingFragment<ViewModel, DataBinding>()
        , IToolbarDelegate by ToolbarDelegate()
        , ToolbarProvider {

    @CallSuper
    override fun setupUi() {
        super.setupUi()
        initToolbarDelegate(this, this, mActivity)
    }


}
