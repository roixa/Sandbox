package com.roix.semenbelalov.common.ui.delegates.vvm.list_rx

import io.reactivex.Single

interface ListSingleSource<Item> {
    fun getItems(): Single<List<Item>>
}