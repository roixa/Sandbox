package com.roix.semenbelalov.sandbox.ui.common.activities

import android.databinding.ViewDataBinding
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx.IListHandleViewDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx.ListHandleViewDelagate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx.ListProvider
import com.roix.semenbelalov.sandbox.ui.common.viewmodels.BaseListViewModel

/**
 * Created by roix template
 * https://github.com/roixa/RoixArchitectureTemplates
 */
abstract class BaseListActivity<ViewModel : BaseListViewModel<Item>, DataBinding : ViewDataBinding, ItemDataBinding : ViewDataBinding, Item>
    : BaseToolbarActivity<ViewModel, DataBinding>()
        , IListHandleViewDelegate<Item> by ListHandleViewDelagate<Item, DataBinding>()
        , ListProvider {


    override fun setupUi() {
        super.setupUi()
        initListHandle(this, getViewModel())
    }


}
