package com.roix.semenbelalov.common.ui.delegates.vvm.list_rx

interface IListHandleViewDelegate<Item> {
    fun initListHandle(provider: ListProvider, viewModelDelegate: IListHandleViewModelDelegate<Item>)
}