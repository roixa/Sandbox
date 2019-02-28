package com.roix.semenbelalov.common.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roix.semenbelalov.common.ui.delegates.view.databinding.LayoutIdProvider
import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate
import com.roix.semenbelalov.common.ui.delegates.view.sub_livedata.LiveDataSubscriptionDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.core.IViewModelHandleDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.core.ViewModelHandleDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.error.ErrorHandleViewDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.error.IErrorHandleViewDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.loading.ILoadingHandleDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.loading.LoadingHandleDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.message.IShowMessageDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.message.ShowMessageDelegate
import com.roix.semenbelalov.common.ui.viewmodels.BaseLifecycleViewModel
import java.lang.reflect.ParameterizedType

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseLifecycleActivity< ViewModel : BaseLifecycleViewModel> : AppCompatActivity()
        , LayoutIdProvider
        , ILiveDataSubscriptionDelegate by LiveDataSubscriptionDelegate()
        , IErrorHandleViewDelegate by ErrorHandleViewDelegate()
        , IShowMessageDelegate by ShowMessageDelegate()
        , ILoadingHandleDelegate by LoadingHandleDelegate()
        , IViewModelHandleDelegate<ViewModel> by ViewModelHandleDelegate() {


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initViewModel(this, getViewModelJavaClass())
        initLiveDataSubscription(this)
        initErrorHandle(this, viewModel)
        initShowMessageHandle(this, this, viewModel)
        initLoadingHandle(this, viewModel)
        viewModel.onBindView(application)
        setupUi()
    }


    protected open fun setupUi() {

    }

    private fun getViewModelJavaClass(): Class<ViewModel> {
        return (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModel>
    }

}
