package com.roix.semenbelalov.sandbox.ui.common.viewmodels

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.roix.semenbelalov.sandbox.application.CommonApplication
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.di_toothpick.DIToothpickDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.di_toothpick.IDIDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.di_toothpick.ModuleProvider
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.sub_rx.IRxSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.sub_rx.RxSubscriptionDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.ErrorHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.IErrorHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.ILoadingViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.LoadingViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.IShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.ShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.navigation.IViewModelNavigationDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.navigation.ViewModelNavigationDelegate
import com.roix.semenbelalov.sandbox.utils.rx.general.RxSchedulersAbs
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseViewModel : ViewModel()
//        , IViewModelLyfecycleDelegate by ViewModelLifecycleDelegate()
        , IErrorHandleViewModelDelegate by ErrorHandleViewModelDelegate()
        , IShowMessageHandleViewModelDelegate by ShowMessageHandleViewModelDelegate()
        , ILoadingViewModelDelegate by LoadingViewModelDelegate()
        , IRxSubscriptionDelegate by RxSubscriptionDelegate()
        , IDIDelegate by DIToothpickDelegate()
        , IViewModelNavigationDelegate by ViewModelNavigationDelegate()
        , ModuleProvider {

    @Inject
    lateinit var rxScheduler: RxSchedulersAbs

    private var viewsCount = 0

    @CallSuper
    fun onBindView(application: Application) {
        if (viewsCount == 0) {
            onBindFirstView(application)
        }
        viewsCount++
    }

    @CallSuper
    open fun onBindFirstView() {

    }

    @CallSuper
    fun onBindFirstView(application: Application) {
        initDIDelegate(application as CommonApplication, this, this)
        initSubscriptionDelegate(rxScheduler, this, this)
        onBindFirstView()
    }


    @CallSuper
    override fun onCleared() {
        super.onCleared()
        clearRxSubsctiptionDelegate()
        clearDiDelegate()
    }

}
