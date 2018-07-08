package com.roix.semenbelalov.sandbox.ui.common.viewmodels

import com.roix.semenbelalov.sandbox.buissness.common.IBaseListInteractor
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx.IListHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx.ListHandleViewModelDelegate


/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */

abstract class BaseListViewModel<Item> : BaseLifecycleViewModel()
        , IListHandleViewModelDelegate<Item> by ListHandleViewModelDelegate() {


    protected abstract fun getInteractor(): IBaseListInteractor<Item>

    override fun onBindFirstView() {
        super.onBindFirstView()
        initListHandle(getInteractor(),this)
    }


}
