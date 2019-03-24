package com.roix.semenbelalov.sandbox.ui.common.viewmodels

import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list.IListHandleViewModelDelegate
import com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list.ListHandleViewModelDelegate

abstract class BaseListViewModel<Item> : BaseViewModel()
        , IListHandleViewModelDelegate<Item> by ListHandleViewModelDelegate<Item>()