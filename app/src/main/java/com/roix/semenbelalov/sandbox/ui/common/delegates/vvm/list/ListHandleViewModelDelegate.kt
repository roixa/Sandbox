package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list

class ListHandleViewModelDelegate<Item> : IListHandleViewModelDelegate<Item> {

    override val items: ListLiveData<Item> = ListLiveData()

    //TODO maybe add logic to this
    override fun refresh() {

    }
}