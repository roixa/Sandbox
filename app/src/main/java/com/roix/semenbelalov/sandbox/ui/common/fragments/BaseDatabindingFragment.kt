package com.roix.semenbelalov.sandbox.ui.common.fragments

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roix.semenbelalov.sandbox.application.CommonApplication
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.databinding.DatabindingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.databinding.IDatabindingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.databinding.LayoutIdProvider
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.LiveDataSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core.IViewModelHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core.ViewModelHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.ErrorHandleViewDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.IErrorHandleViewDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.ILoadingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.LoadingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.IShowMessageDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.ShowMessageDelegate
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel
import ru.terrakok.cicerone.Navigator
import java.lang.reflect.ParameterizedType

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseDatabindingFragment<ViewModel : BaseLifecycleViewModel, DataBinding : ViewDataBinding> : Fragment()
        , LayoutIdProvider
        , IDatabindingHandleDelegate<DataBinding> by DatabindingHandleDelegate()
        , ILiveDataSubscriptionDelegate by LiveDataSubscriptionDelegate()
        , IErrorHandleViewDelegate by ErrorHandleViewDelegate()
        , IShowMessageDelegate by ShowMessageDelegate()
        , ILoadingHandleDelegate by LoadingHandleDelegate()
        , IViewModelHandleDelegate<ViewModel> by ViewModelHandleDelegate<ViewModel>() {


    //TODO strange bug after cicerone
    protected lateinit var mActivity: AppCompatActivity

    protected open fun getNavigator(): Navigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel(activity as AppCompatActivity,getViewModelJavaClass() )
        initLoadingHandle(this, getViewModel())

        initLiveDataSubscription(this)
        initErrorHandle(this, getViewModel())
        initShowMessageHandle(activity!!, this, getViewModel())
        initLoadingHandle(this, getViewModel())
        getViewModel().onBindView(activity!!.application as CommonApplication)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupUi()
        return initBinding(activity as AppCompatActivity, getLayoutId(), inflater, container, getViewModel()).root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        refresh()
    }


    protected open fun setupUi() {

    }

    //handle this if you want to refresh data in a reattached fragment
    protected open fun refresh() {

    }

    open fun goBack(): Boolean {//return used in fragment
        return false
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

    private fun getViewModelJavaClass(): Class<ViewModel> {
        return (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModel>
    }

}