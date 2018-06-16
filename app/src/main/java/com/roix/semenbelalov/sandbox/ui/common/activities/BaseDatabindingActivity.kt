package com.roix.semenbelalov.sandbox.ui.common.activities

import android.databinding.ViewDataBinding
import android.support.annotation.CallSuper
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view.DatabindingDelegate
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view.IDatabindingDelegate
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel
import ru.terrakok.cicerone.Navigator


/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseDatabindingActivity<ViewModel : BaseLifecycleViewModel, out DataBinding : ViewDataBinding> : BaseLifecycleActivity<ViewModel>()
        , IDatabindingDelegate<DataBinding> by DatabindingDelegate() {


    protected open fun getNavigator(): Navigator? = null

    override fun setupUi() {
        super.setupUi()
        setupBinding()
    }

    @CallSuper
    protected open fun setupBinding() {
         initBinding(this,getLayoutId(), viewModel)
        resources.configuration
    }

    override fun onResume() {
        super.onResume()
        val navigator = getNavigator()
        if (navigator != null) {
            viewModel.navigatorHolder.setNavigator(navigator)
        }
    }

    override fun onPause() {
        super.onPause()
        val navigator = getNavigator()
        if (navigator != null) {
            viewModel.navigatorHolder.removeNavigator()
        }
    }
}
