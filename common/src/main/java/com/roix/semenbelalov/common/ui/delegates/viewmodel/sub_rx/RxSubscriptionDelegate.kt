package com.roix.semenbelalov.common.ui.delegates.viewmodel.sub_rx

import com.roix.semenbelalov.common.ui.delegates.vvm.error.IErrorHandleViewModelDelegate
import com.roix.semenbelalov.common.ui.delegates.vvm.loading.ILoadingViewModelDelegate
import com.roix.semenbelalov.common.utils.rx.general.RxSchedulersAbs
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class RxSubscriptionDelegate : IRxSubscriptionDelegate {

    val subscription: CompositeDisposable = CompositeDisposable()
    lateinit var rxScheduler: RxSchedulersAbs
    lateinit var loading: ILoadingViewModelDelegate
    lateinit var error: IErrorHandleViewModelDelegate

    override fun initSubscriptionDelegate(rxScheduler: RxSchedulersAbs, loading: ILoadingViewModelDelegate, error: IErrorHandleViewModelDelegate) {
        this.rxScheduler = rxScheduler
        this.loading = loading
        this.error = error
        onBindFirstView(subscription)
    }

    override fun onBindFirstView(subscription: CompositeDisposable) {
    }

    override fun <T> Observable<T>.withDefaultShedulers(): Observable<T> {
        return compose(rxScheduler.getIOToMainTransformer())
    }

    override fun Completable.withDefaultShedulers(): Completable {
        return compose(rxScheduler.getIoToMainTransformerCompletable())
    }

    override fun <T> Observable<T>.withLoadingHandle(): Observable<T> {
        return doOnSubscribe({
            loading.onStartLoad()
        }).doAfterTerminate({
            loading.onEndLoad()
        })
    }

    override fun Completable.withLoadingHandle(): Completable {
        return doOnSubscribe({
            loading.onStartLoad()
        }).doAfterTerminate({
            loading.onEndLoad()
        })
    }

    override fun <T> Observable<T>.sub(function: (T) -> Unit) {
        subscription.add(
                withLoadingHandle()
                        .withDefaultShedulers()
                        .subscribe({ T ->
                            function.invoke(T)
                        }, { t -> error.handleError(t) })
        )
    }

    override fun <T> Single<T>.sub(function: (T) -> Unit) {
        toObservable().sub(function)
    }

    override fun <T> sub(function: (T) -> Unit, single: Single<T>) {
        single.toObservable().sub(function)
    }


    override fun Completable.sub(function: () -> Unit) {
        subscription.add(
                withLoadingHandle()
                        .withDefaultShedulers()
                        .subscribe({
                            function.invoke()
                        }, { t -> error.handleError(t) })
        )

    }

    override fun clearRxSubsctiptionDelegate() {
        subscription.dispose()
    }
}