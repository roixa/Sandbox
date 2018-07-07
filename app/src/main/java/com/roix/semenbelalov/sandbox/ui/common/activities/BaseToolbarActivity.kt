package com.roix.semenbelalov.sandbox.ui.common.activities

import android.databinding.ViewDataBinding
import android.support.annotation.CallSuper
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.roix.semenbelalov.sandbox.BR
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.databinding.MenuItemBinding
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.IToolbarDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.ToolbarDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.ToolbarProvider
import com.roix.semenbelalov.sandbox.ui.common.view.ToolbarType
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseToolbarActivity< ViewModel : BaseLifecycleViewModel, out DataBinding : ViewDataBinding>
    : BaseDatabindingActivity<ViewModel, DataBinding>()
        , IToolbarDelegate by ToolbarDelegate()
        , ToolbarProvider {


    @CallSuper
    override fun setupUi() {
        super.setupUi()
        initToolbarDelegate(this, this, this)
    }


}
