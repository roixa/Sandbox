package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx

import android.databinding.ObservableList
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.sub_rx.IRxSubscriptionDelegate

interface IListHandleViewModelDelegate<Item> {
    fun initListHandle(source: ListSingleSource<Item>, subDelegate: IRxSubscriptionDelegate)
    fun refresh()
    fun getItems(): ObservableList<Item>
}