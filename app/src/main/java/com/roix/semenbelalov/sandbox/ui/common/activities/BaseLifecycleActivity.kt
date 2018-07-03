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
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import java.lang.reflect.ParameterizedType

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseLifecycleActivity<ViewModel : BaseLifecycleViewModel> : AppCompatActivity()
        , ILiveDataSubscriptionDelegate by LiveDataSubscriptionDelegate()
        , IErrorHandleViewDelegate by ErrorHandleViewDelegate()
        , IShowMessageDelegate by ShowMessageDelegate() {

    @IdRes
    abstract fun getLayoutId(): Int

    protected lateinit var viewModel: ViewModel

    //TODO: using global progressDialog design pattern is depricated
    private lateinit var progressDialog: ProgressDialog

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = bindViewModel(getViewModelJavaClass())
        setupUi()
    }

    private fun <T : BaseLifecycleViewModel> bindViewModel(clazz: Class<T>): T {
        val viewModel = ViewModelProviders.of(this).get(clazz)
        initLiveDataSubscription(this)
        initErrorHandle(this, viewModel)
        initShowMessageHandle(this, this, viewModel)
        viewModel.loadingLiveData.sub { b -> handleProgress(b) }
        viewModel.onBindView(application as CommonApplication)
        return viewModel
    }

    protected open fun setupUi() {
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage(getString(R.string.text_dialog_progress))
        progressDialog.setCancelable(false)
    }

    @CallSuper
    protected open fun handleProgress(isProgress: Boolean) {
        if (isProgress) {
            progressDialog.show()
        } else {
            progressDialog.hide()
        }
    }

    @CallSuper
    protected open fun showMessageDialog(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun handleError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
    }


    private fun getViewModelJavaClass(): Class<ViewModel> {
        return (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModel>
    }

}
