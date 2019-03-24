package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list

interface IListHandleViewModelDelegate<Item> {
    fun refresh()
    val items: ListLiveData<Item>
}