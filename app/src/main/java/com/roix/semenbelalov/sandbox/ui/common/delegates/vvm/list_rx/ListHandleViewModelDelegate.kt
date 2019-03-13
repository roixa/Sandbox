package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.sub_rx.IRxSubscriptionDelegate

class ListHandleViewModelDelegate<Item> : IListHandleViewModelDelegate<Item> {

    override val items: ObservableList<Item> = ObservableArrayList<Item>()

    lateinit var subscriptionDelegate: IRxSubscriptionDelegate
    lateinit var listSingleSource: ListSingleSource<Item>

    override fun initListHandle(source: ListSingleSource<Item>, subDelegate: IRxSubscriptionDelegate) {
        subscriptionDelegate = subDelegate
        listSingleSource = source
        subDelegate.sub({
            items.clear()
            items.addAll(it)
        }, source.getItems())
    }

    override fun refresh() {
        listSingleSource.let {source->
            subscriptionDelegate.sub({
                items.clear()
                items.addAll(it)
            }, source.getItems())

        }
    }

}