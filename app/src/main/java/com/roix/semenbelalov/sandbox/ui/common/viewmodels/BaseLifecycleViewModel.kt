package com.roix.semenbelalov.sandbox.ui.common.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import io.reactivex.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject


/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseLifecycleViewModel : BaseViewModel(){

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router

    override fun <T> Observable<T>.withDefaultLoadingHandle(): Observable<T> {
        return withLoadingHandle()
    }

    fun Completable.withDefaultLoadingHandle(): Completable {
        return withLoadingHandle()
    }


    fun <T> toLiveDataFun(observable: Observable<T>): LiveData<T> = LiveDataReactiveStreams.fromPublisher(
            observable
                    .withDefaultLoadingHandle()
                    .withDefaultShedulers()
                    .onErrorResumeNext { t: Throwable ->
                        onEndLoad()
                        return@onErrorResumeNext Observable.never<T>()
                    }.toFlowable(BackpressureStrategy.BUFFER))


    fun Completable.sub(function: () -> Unit) {
        subscription.add(
                withDefaultLoadingHandle().withDefaultShedulers().subscribe({
                    function.invoke()
                }, { t -> handleError(t) })
        )

    }

}
