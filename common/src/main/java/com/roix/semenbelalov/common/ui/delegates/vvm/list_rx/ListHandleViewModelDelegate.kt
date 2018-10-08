package com.roix.semenbelalov.common.ui.delegates.vvm.list_rx

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.roix.semenbelalov.common.ui.delegates.viewmodel.sub_rx.IRxSubscriptionDelegate
import java.lang.ref.WeakReference

class ListHandleViewModelDelegate<Item> : IListHandleViewModelDelegate<Item> {

    val mItems: ObservableList<Item> = ObservableArrayList<Item>()
    lateinit var subscriptionDelegate: WeakReference<IRxSubscriptionDelegate>
    lateinit var listSingleSource: WeakReference<ListSingleSource<Item>>

    override fun initListHandle(source: ListSingleSource<Item>, subDelegate: IRxSubscriptionDelegate) {
        subscriptionDelegate = WeakReference(subDelegate)
        listSingleSource = WeakReference(source)
        subDelegate.sub({
            mItems.clear()
            mItems.addAll(it)
        }, source.getItems())
    }

    override fun refresh() {
        listSingleSource.get()?.let {source->
            subscriptionDelegate.get()?.sub({
                mItems.clear()
                mItems.addAll(it)
            }, source.getItems())

        }
    }

    override fun getItems(): ObservableList<Item> = mItems
}