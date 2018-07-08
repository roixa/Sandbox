package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.roix.semenbelalov.sandbox.ui.common.delegates.viewmodel.sub_rx.IRxSubscriptionDelegate
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