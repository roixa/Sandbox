package com.roix.semenbelalov.sandbox.ui.common.activities

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.roix.semenbelalov.sandbox.R
import com.roix.semenbelalov.sandbox.application.CommonApplication
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel
import android.arch.lifecycle.MutableLiveData
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view.*
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.ILoadingViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.LoadingViewModelDelegate
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import java.lang.reflect.ParameterizedType

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseLifecycleActivity<out ViewModel : BaseLifecycleViewModel> : AppCompatActivity()
        ,LayoutIdProvider
        , ILiveDataSubscriptionDelegate by LiveDataSubscriptionDelegate()
        , IErrorHandleViewDelegate by ErrorHandleViewDelegate()
        , IShowMessageDelegate by ShowMessageDelegate()
        , ILoadingHandleDelegate by LoadingHandleDelegate()
        , IViewModelHandleDelegate<ViewModel> by ViewModelHandleDelegate(){


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
