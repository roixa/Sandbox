package com.roix.semenbelalov.sandbox.ui.common.activities

import android.databinding.ViewDataBinding
import android.support.annotation.CallSuper
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view.DatabindingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view.IDatabindingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel
import ru.terrakok.cicerone.Navigator


/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseDatabindingActivity<out ViewModel : BaseLifecycleViewModel, out DataBinding : ViewDataBinding> : BaseLifecycleActivity<ViewModel>()
        , IDatabindingHandleDelegate<DataBinding> by DatabindingHandleDelegate() {


    protected open fun getNavigator(): Navigator? = null

    override fun setupUi() {
        super.setupUi()
        initBinding(this,getLayoutId(), getViewModel())

    }


    override fun onResume() {
        super.onResume()
        val navigator = getNavigator()
        if (navigator != null) {
            getViewModel().navigatorHolder.setNavigator(navigator)
        }
    }

    override fun onPause() {
        super.onPause()
        val navigator = getNavigator()
        if (navigator != null) {
            getViewModel().navigatorHolder.removeNavigator()
        }
    }
}