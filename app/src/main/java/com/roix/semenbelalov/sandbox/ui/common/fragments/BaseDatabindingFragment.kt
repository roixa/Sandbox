package com.roix.semenbelalov.sandbox.ui.common.fragments

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import android.app.Activity
import ru.terrakok.cicerone.Navigator
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roix.semenbelalov.sandbox.application.CommonApplication
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.view.*
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.IShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.activities.delegates.viewmodel.ShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseLifecycleViewModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import java.lang.reflect.ParameterizedType

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseDatabindingFragment<ViewModel : BaseLifecycleViewModel, DataBinding : ViewDataBinding> : Fragment()
        , IDatabindingHandleDelegate<DataBinding> by DatabindingHandleDelegate()
        , ILiveDataSubscriptionDelegate by LiveDataSubscriptionDelegate()
        , IErrorHandleViewDelegate by ErrorHandleViewDelegate()
        , IShowMessageDelegate by ShowMessageDelegate() {

    protected lateinit var viewModel: ViewModel


    //TODO strange bug after cicerone
    protected lateinit var mActivity: Activity

    protected open fun getNavigator(): Navigator? = null

    abstract fun getLayoutId(): Int

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("boux", "fragment onCreate " + javaClass)
        viewModel = bindViewModel(getViewModelJavaClass())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d("boux", "fragment onCreateView " + javaClass)

        setupUi()

        return initBinding(activity as AppCompatActivity, getLayoutId(), inflater, container, viewModel).root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        refresh()
    }


    protected open fun setupUi() {

    }

    protected open fun setupBinding() {

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


    @CallSuper
    protected open fun <T : BaseLifecycleViewModel> bindViewModel(clazz: Class<T>): T {
        val viewModel = ViewModelProviders.of(mActivity as FragmentActivity).get(clazz)
        viewModel.loadingLiveData.sub { b -> if (b != null) handleProgress(b) }

        initLiveDataSubscription(this)
        initErrorHandle(this, viewModel)
        initShowMessageHandle(activity!!, this, viewModel)
        viewModel.onBindView(mActivity.application as CommonApplication)
        return viewModel
    }


    protected open fun handleProgress(isProgress: Boolean) {

    }

    protected open fun showMessageDialog(message: String) {
        //Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }


    private fun getViewModelJavaClass(): Class<ViewModel> {
        return (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<ViewModel>
    }


}