package com.roix.semenbelalov.sandbox.ui.common.viewmodels

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import com.roix.semenbelalov.sandbox.application.CommonApplication
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.ErrorHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.error.IErrorHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.ILoadingViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.loading.LoadingViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.IShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.message.ShowMessageHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.utils.rx.general.RxSchedulersAbs

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseViewModel : ViewModel()
        , IErrorHandleViewModelDelegate by ErrorHandleViewModelDelegate()
        , IShowMessageHandleViewModelDelegate by ShowMessageHandleViewModelDelegate()
        , ILoadingViewModelDelegate by LoadingViewModelDelegate() {

    private var viewsCount = 0

    protected val subscription: CompositeDisposable = CompositeDisposable()


    private lateinit var viewModelScope: Scope

    @Inject
    lateinit var rxScheduler: RxSchedulersAbs

    protected abstract fun getModule(): Module

    @CallSuper
    open fun onBindView(application: CommonApplication) {
        if (viewsCount == 0) {
            proceedInject(application)
            onBindFirstView()
        }
        viewsCount++
    }

    @CallSuper
    protected open fun onBindFirstView() {
        onBindFirstView(subscription)
    }

    protected open fun proceedInject(application: CommonApplication) {
        viewModelScope = Toothpick.openScopes(application, this)
        viewModelScope.installModules(getModule())
        Toothpick.inject(this, viewModelScope)
    }


    protected open fun onBindFirstView(subscription: CompositeDisposable) {}

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
        Toothpick.closeScope(viewModelScope)
    }

    open fun <T> Observable<T>.withDefaultShedulers(): Observable<T> {
        return compose(rxScheduler.getIOToMainTransformer())
    }

    open fun Completable.withDefaultShedulers(): Completable {
        return compose(rxScheduler.getIoToMainTransformerCompletable())
    }

    fun <T> Observable<T>.withLoadingHandle(): Observable<T> {
        return doOnSubscribe({
            onStartLoad()
        }).doAfterTerminate({
            onEndLoad()
        })
    }

    fun Completable.withLoadingHandle(): Completable {
        return doOnSubscribe({
            onStartLoad()
        }).doAfterTerminate({
            onEndLoad()
        })
    }

    abstract fun <T> Observable<T>.withDefaultLoadingHandle(): Observable<T>


    fun <T> Observable<T>.sub(function: (T) -> Unit) {
        subscription.add(
                withDefaultLoadingHandle().withDefaultShedulers().subscribe({ T ->
                    function.invoke(T)
                }, { t -> handleError(t) })
        )
    }

    fun <T> Single<T>.sub(function: (T) -> Unit) = this.toObservable().sub { T -> function.invoke(T) }


}
