package com.roix.semenbelalov.common.ui.viewmodels

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.roix.semenbelalov.common.ui.delegates.viewmodel.core.IViewModelInitDelegate
import com.roix.semenbelalov.common.ui.delegates.viewmodel.core.ViewModelInitDelegate
import com.roix.semenbelalov.common.ui.delegates.viewmodel.di_toothpick.DIToothpickDelegate
import com.roix.semenbelalov.common.ui.delegates.viewmodel.di_toothpick.IDIDelegate
import com.roix.semenbelalov.common.ui.delegates.viewmodel.di_toothpick.ModuleProvider
import com.roix.semenbelalov.common.ui.delegates.viewmodel.sub_rx.IRxSubscriptionDelegate
import com.roix.semenbelalov.common.ui.delegates.viewmodel.sub_rx.RxSubscriptionDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.error.ErrorHandleViewModelDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.error.IErrorHandleViewModelDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.loading.ILoadingViewModelDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.loading.LoadingViewModelDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.message.IShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.message.ShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.common.utils.rx.general.RxSchedulersAbs
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseViewModel : ViewModel()
        , IViewModelInitDelegate by ViewModelInitDelegate()
        , IErrorHandleViewModelDelegate by ErrorHandleViewModelDelegate()
        , IShowMessageHandleViewModelDelegate by ShowMessageHandleViewModelDelegate()
        , ILoadingViewModelDelegate by LoadingViewModelDelegate()
        , IRxSubscriptionDelegate by RxSubscriptionDelegate()
        , IDIDelegate by DIToothpickDelegate()
        , ModuleProvider {

    @Inject
    lateinit var rxScheduler: RxSchedulersAbs

    @CallSuper
    override fun onBindFirstView(application: Application) {
        initDIDelegate(application, this)
        initSubscriptionDelegate(rxScheduler, this, this)
    }


    @CallSuper
    override fun onCleared() {
        super.onCleared()
        clearRxSubsctiptionDelegate()
        clearDiDelegate()
    }

}
