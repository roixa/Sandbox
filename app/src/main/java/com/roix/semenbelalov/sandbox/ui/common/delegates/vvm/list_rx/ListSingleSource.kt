package com.roix.semenbelalov.sandbox.ui.common.delegates.vvm.list_rx

import io.reactivex.Single

interface ListSingleSource<Item> {
    fun getItems(): Single<List<Item>>
}