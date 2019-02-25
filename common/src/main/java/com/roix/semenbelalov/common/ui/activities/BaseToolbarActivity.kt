package com.roix.semenbelalov.common.ui.activities

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import com.roix.semenbelalov.common.ui.delegates.view.toolbar.IToolbarDelegate
import com.roix.semenbelalov.common.ui.delegates.view.toolbar.ToolbarDelegate
import com.roix.semenbelalov.common.ui.delegates.view.toolbar.ToolbarProvider
import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseToolbarActivity< ViewModel : BaseLifecycleViewModel, DataBinding : ViewDataBinding>
    : BaseDatabindingActivity<ViewModel, DataBinding>()
        , IToolbarDelegate by ToolbarDelegate()
        , ToolbarProvider {


    @CallSuper
    override fun setupUi() {
        super.setupUi()
        initToolbarDelegate(this, this, this)
    }


}
