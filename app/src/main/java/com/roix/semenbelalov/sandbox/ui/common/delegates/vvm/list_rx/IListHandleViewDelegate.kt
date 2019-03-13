package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx

interface IListHandleViewDelegate<Item> {
    fun initListHandle(provider: ListProvider, viewModelDelegate: IListHandleViewModelDelegate<Item>)
}