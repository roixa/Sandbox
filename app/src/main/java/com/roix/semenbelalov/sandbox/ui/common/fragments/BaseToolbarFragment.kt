package com.roix.semenbelalov.sandbox.ui.common.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.databinding.DatabindingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.databinding.IDatabindingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.databinding.LayoutIdProvider
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.LiveDataSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.IToolbarDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.ToolbarDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.toolbar.ToolbarProvider
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core.IViewModelHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core.ViewModelHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.ErrorHandleViewDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.IErrorHandleViewDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.ILoadingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.LoadingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.IShowMessageDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.ShowMessageDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.navigation.INavigationDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.navigation.NavigationDelegate
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseToolbarFragment<ViewModel : BaseViewModel, DataBinding : ViewDataBinding> : Fragment()
        , LayoutIdProvider
        , ToolbarProvider
        , IDatabindingHandleDelegate<DataBinding, ViewModel> by DatabindingHandleDelegate()
        , ILiveDataSubscriptionDelegate by LiveDataSubscriptionDelegate()
        , IErrorHandleViewDelegate by ErrorHandleViewDelegate()
        , IShowMessageDelegate by ShowMessageDelegate()
        , ILoadingHandleDelegate by LoadingHandleDelegate()
        , IViewModelHandleDelegate<ViewModel> by ViewModelHandleDelegate<ViewModel>()
        , INavigationDelegate by NavigationDelegate()
        , IToolbarDelegate by ToolbarDelegate() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel(activity as AppCompatActivity, getViewModelJavaClass())
        initLoadingHandle(this, viewModel)

        initLiveDataSubscription(this)
        initErrorHandle(this, viewModel)
        initShowMessageHandle(activity!!, this, viewModel)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel.onBindView(activity!!.application)
        setupUi()
        val ret = initBinding(activity as AppCompatActivity, layoutId, inflater, container, viewModel).root
        initToolbarDelegate(this, this, this, activity as Context)
        return ret
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigationHandle(binding.root, this, viewModel)
        setupBinding()
    }

    protected open fun setupUi() {

    }

    protected open fun setupBinding() {}

    private fun getViewModelJavaClass(): Class<ViewModel> {
        return (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModel>
    }


}
