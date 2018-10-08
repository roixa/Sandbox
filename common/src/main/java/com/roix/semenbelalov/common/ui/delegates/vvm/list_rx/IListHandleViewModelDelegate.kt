package com.roix.semenbelalov.common.ui.delegates.vvm.list_rx

import androidx.databinding.ObservableList
import com.roix.semenbelalov.common.ui.delegates.viewmodel.sub_rx.IRxSubscriptionDelegate

interface IListHandleViewModelDelegate<Item> {
    fun initListHandle(source: ListSingleSource<Item>, subDelegate: IRxSubscriptionDelegate)
    fun refresh()
    fun getItems(): ObservableList<Item>
}