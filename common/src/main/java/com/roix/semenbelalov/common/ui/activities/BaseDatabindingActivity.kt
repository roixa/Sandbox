package com.roix.semenbelalov.common.ui.activities


import androidx.databinding.ViewDataBinding
import com.roix.semenbelalov.common.ui.delegates.view.databinding.DatabindingHandleDelegate
import com.roix.semenbelalov.common.ui.delegates.view.databinding.IDatabindingHandleDelegate
import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import ru.terrakok.cicerone.Navigator


/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseDatabindingActivity< ViewModel : BaseLifecycleViewModel, DataBinding : ViewDataBinding> : BaseLifecycleActivity<ViewModel>()
        , IDatabindingHandleDelegate<DataBinding,ViewModel> by DatabindingHandleDelegate() {


    protected open fun getNavigator(): Navigator? = null

    override fun setupUi() {
        super.setupUi()
        initBinding(this,getLayoutId(), viewModel)
        setupBinding()
    }

    open fun setupBinding() {}

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
