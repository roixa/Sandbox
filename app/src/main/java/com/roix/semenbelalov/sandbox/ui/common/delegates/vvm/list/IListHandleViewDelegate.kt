package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list

import com.roix.semenbelalov.sandbox.ui.common.delegates.view.sub_livedata.ILiveDataSubscriptionDelegate

interface IListHandleViewDelegate<Item> {
    fun initListHandle(viewProvider: ListViewProvider, subscription: ILiveDataSubscriptionDelegate, source: IListHandleViewModelDelegate<Item>)
}