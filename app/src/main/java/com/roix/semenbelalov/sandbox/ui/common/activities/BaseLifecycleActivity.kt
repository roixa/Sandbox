package com.roix.semenbelalov.sandbox.ui.common.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.roix.semenbelalov.sandbox.application.CommonApplication
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.LayoutIdProvider
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.LiveDataSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.core.*
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.ErrorHandleViewDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.IErrorHandleViewDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.ILoadingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.LoadingHandleDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.IShowMessageDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.ShowMessageDelegate

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseLifecycleActivity<out ViewModel : BaseLifecycleViewModel> : AppCompatActivity()
        , LayoutIdProvider
        , ILiveDataSubscriptionDelegate by LiveDataSubscriptionDelegate()
        , IErrorHandleViewDelegate by ErrorHandleViewDelegate()
        , IShowMessageDelegate by ShowMessageDelegate()
        , ILoadingHandleDelegate by LoadingHandleDelegate()
        , IViewModelHandleDelegate<ViewModel> by ViewModelHandleDelegate() {


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initViewModel(this)
        initLiveDataSubscription(this)
        initErrorHandle(this, getViewModel())
        initShowMessageHandle(this, this, getViewModel())
        initLoadingHandle(this, getViewModel())
        getViewModel().onBindView(application as CommonApplication)
        setupUi()
    }


    protected open fun setupUi() {

    }


}
